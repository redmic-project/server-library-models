package es.redmic.models.es.geojson.tracking.platform.dto;

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

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.algorithm.Centroid;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.ClusterPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaDataFeatureDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.geojson.common.model.GeoHitWrapper;
import es.redmic.models.es.geojson.common.model.GeoPointData;

public class PlatformTrackingClusterDTO extends MetaFeatureDTO<ClusterPropertiesDTO, Point> {

	private GeometryFactory geomFactory = new GeometryFactory();

	private List<Geometry> geometries = new ArrayList<Geometry>();

	public PlatformTrackingClusterDTO() {

		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		setProperties(new ClusterPropertiesDTO());
	}

	public void addPoint(GeoHitWrapper<?, Point> point) {

		GeoPointData feature = (GeoPointData) point.get_source();
		getProperties().addDate(feature.getProperties().getInTrack().getDate());
		getProperties().addUuid(feature.getUuid());

		MetaDataFeatureDTO meta = new MetaDataFeatureDTO();
		meta.setCategory(DataPrefixType.PLATFORM_TRACKING);
		meta.setVersion(point.get_version());
		set_meta(meta);
		updateCentroidPoint(feature.getGeometry());
	}

	private void updateCentroidPoint(Geometry point) {

		geometries.add(point);
		Centroid centroid = new Centroid(geomFactory.buildGeometry(geometries));
		setGeometry(geomFactory.createPoint(centroid.getCentroid()));
	}
}
