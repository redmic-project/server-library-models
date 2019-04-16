package es.redmic.models.es.atlas.dto;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.geotools.data.ows.CRSEnvelope;
import org.geotools.data.ows.Layer;
import org.geotools.data.ows.StyleImpl;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import es.redmic.exception.custom.ResourceNotFoundException;
import es.redmic.models.es.administrative.dto.AncestorActivityDTO;
import es.redmic.models.es.atlas.Contact;
import es.redmic.models.es.atlas.StyleLayer;

public class LayerDTO extends LayerCompactDTO {

	private String title;
	private String abstractLayer;
	private List<String> keyword;
	private List<String> srs;
	private StyleLayer styleLayer;
	private Contact contact;
	private List<String> idActivities;
	@JsonIgnoreProperties(value = { "_meta" })
	private List<AncestorActivityDTO> activities;
	private String urlSource;

	private Boolean queryable;
	private List<String> formats;
	private String image;

	private Geometry geometry;

	public LayerDTO() {
	}

	public LayerDTO(Layer layer) {

		setName(layer.getName());

		if (getTitle() != null)
			setAlias(layer.getTitle());
		else
			setAlias(layer.getName());

		setTitle(layer.getTitle());

		if (layer.getSrs() != null)
			setSrs(layer.getSrs().toArray());

		setKeyword(layer.getKeywords());
		parseAbstractLayer(layer.get_abstract());
		setStyleLayer(layer.getStyles());
		setBoundingBox(layer.getBoundingBoxes());
		setQueryable(layer.isQueryable());
		prepareDTO();
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getKeyword() {
		return keyword;
	}

	@JsonSetter("keyword")
	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}

	public void setKeyword(String[] keywordList) {
		this.keyword = new ArrayList<String>();
		if (keywordList != null) {
			for (int i = 0; i < keywordList.length; i++) {
				this.keyword.add(keywordList[i]);
			}
		}
	}

	public List<String> getSrs() {
		return srs;
	}

	@JsonSetter("srs")
	public void setSrs(List<String> srs) {
		this.srs = srs;
	}

	public void setSrs(Object[] srs) {
		this.srs = new ArrayList<String>();
		for (int i = 0; i < srs.length; i++)
			this.srs.add(srs[i].toString());
	}

	@JsonIgnore
	public List<String> getIdActivities() {
		return idActivities;
	}

	@JsonIgnore
	public void setIdActivities(List<String> activities) {
		this.idActivities = activities;
	}

	public void addIdActivities(String[] activities) {
		for (int i = 0; i < activities.length; i++)
			this.idActivities.add(activities[i].toString());
	}

	public void addIdActivity(String activity) {
		this.idActivities.add(activity);
	}

	public List<AncestorActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(List<AncestorActivityDTO> activities) {
		this.activities = activities;
	}

	public void parseAbstractLayer(String abstractLayer) {

		if (abstractLayer != null) {
			idActivities = new ArrayList<String>();

			String expRef = "ref#((\\d*,?)*)#";
			String expSaltLine = "\r?\n|\r";
			String expRefExt = ".*(" + expRef + ").*";

			abstractLayer = abstractLayer.replaceAll(expSaltLine, " ");

			if (abstractLayer.matches(expRefExt)) {
				String ref = abstractLayer.replaceAll(expRefExt, "$1");
				if (ref.matches(expRef)) {
					abstractLayer = abstractLayer.replace(ref, "");
					abstractLayer = abstractLayer.replace("  ", " ");

					String listAct = ref.replaceAll(expRef, "$1");
					String[] listActSplit = listAct.split(",");
					addIdActivities(listActSplit);
				}
			}
			setAbstractLayer(abstractLayer);
		}
	}

	public String getAbstractLayer() {
		return abstractLayer;
	}

	public void setAbstractLayer(String abstractLayer) {
		this.abstractLayer = abstractLayer;
	}

	@JsonGetter("styleLayer")
	public StyleLayer getStyleLayer() {
		return styleLayer;
	}

	@JsonIgnore
	public void setStyleLayer(List<StyleImpl> styleLayer) {

		if (styleLayer != null) {
			for (int i = 0; i < styleLayer.size(); i++)
				this.styleLayer = new StyleLayer(styleLayer.get(i));
		}
	}

	@JsonSetter("styleLayer")
	public void setStyleLayer(StyleLayer styleLayer) {
		this.styleLayer = styleLayer;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	@JsonSetter("geometry")
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public void setBoundingBox(Map<String, CRSEnvelope> boundingBox) {
		String srs = "EPSG:4326";

		if (boundingBox.get(srs) != null) {
			GeometryFactory geomFactory = new GeometryFactory();

			Coordinate[] coordinates = new Coordinate[5];
			coordinates[0] = new Coordinate(boundingBox.get(srs).getMinY(), boundingBox.get(srs).getMinX());
			coordinates[1] = new Coordinate(boundingBox.get(srs).getMinY(), boundingBox.get(srs).getMaxX());
			coordinates[2] = new Coordinate(boundingBox.get(srs).getMaxY(), boundingBox.get(srs).getMaxX());
			coordinates[3] = new Coordinate(boundingBox.get(srs).getMaxY(), boundingBox.get(srs).getMinX());
			coordinates[4] = new Coordinate(boundingBox.get(srs).getMinY(), boundingBox.get(srs).getMinX());

			LinearRing linear = geomFactory.createLinearRing(coordinates);
			Polygon polygon = geomFactory.createPolygon(linear);
			polygon.setSRID(4326);
			setGeometry(polygon);
		}
	}

	@Override
	public String toString() {

		String result = "Name: " + getId() + "\nTitle: " + getTitle() + "\nAbstract: " + getAbstractLayer() + "\nSRS: "
				+ getSrs().size() + "\nKeywords: ";

		for (int i = 0; i < getKeyword().size(); i++) {
			result += getKeyword().get(i) + " ";
		}

		return result;
	}

	public String getUrlSource() {
		return urlSource;
	}

	public void setUrlSource(String urlSource) {
		this.urlSource = urlSource;
	}

	public Boolean getQueryable() {
		return queryable;
	}

	public void setQueryable(Boolean queryable) {
		if (queryable != null)
			this.queryable = queryable;
		else
			this.queryable = false;
	}

	public List<String> getFormats() {
		return formats;
	}

	public void setFormats(List<String> formats) {
		this.formats = formats;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void prepareDTO() {

		if (this.getUrlSource() != null) {

			URL url;
			try {
				url = new URL(this.getUrlSource());
			} catch (MalformedURLException e) {
				throw new ResourceNotFoundException(e);
			}

			String host = "atlas.redmic.es";

			if (url.getHost().equals(host)) {

				this.setUrlSource(this.getUrlSource().replaceFirst("http:", "https:"));
				if (this.getStyleLayer() != null && this.getStyleLayer().getUrl() != null) {
					this.getStyleLayer().setUrl(this.getStyleLayer().getUrl().replaceFirst("http:", "https:"));
					this.getStyleLayer().setUrl(this.getStyleLayer().getUrl().replaceFirst(":80", ""));
				}

			} else
				this.setQueryable(false);
		}
	}
}
