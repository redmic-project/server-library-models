package es.redmic.models.es.geojson.common.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;

import es.redmic.models.es.common.model.SearchWrapper;

public class GeoSearchWrapper<TProperties extends Properties, TGeometry extends Geometry> extends SearchWrapper {
	
	private GeoHitsWrapper<TProperties, TGeometry> hits;

	public GeoHitsWrapper<TProperties, TGeometry> getHits() {
		return hits;
	}

	public void setHits(GeoHitsWrapper<TProperties, TGeometry> hits) {
		this.hits = hits;
	}

	@JsonIgnore
	public Integer getTotal() {
		return getHits() != null ? getHits().getTotal() : 0;
	}

	@JsonIgnore
	public List<Feature<TProperties, TGeometry>> getSourceList() {
		return hits.getSourceList();
	}
	
	@JsonIgnore
	public Feature<TProperties, TGeometry> getSource(int index) {
		
		if (hits.getTotal() < 1)
			return null;
		return (Feature<TProperties, TGeometry>) hits.getHits().get(index).get_source();
	}
	
	@JsonIgnore
	public void setSource(int index, Feature<TProperties, TGeometry> source) {
		
		if (hits.getTotal() > index)
			hits.getHits().get(index).set_source(source);
	}
}
