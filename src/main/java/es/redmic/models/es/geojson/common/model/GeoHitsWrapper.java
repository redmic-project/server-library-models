package es.redmic.models.es.geojson.common.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;

import es.redmic.models.es.common.model.HitsWrapper;

public class GeoHitsWrapper<TProperties extends Properties, TGeometry extends Geometry> extends HitsWrapper {
	
	public GeoHitsWrapper() {
	}
	
	public GeoHitsWrapper(List<GeoHitWrapper<TProperties, TGeometry>> hits) {
		this.hits = hits;
	}
	
	private List<GeoHitWrapper<TProperties, TGeometry>> hits;

	public List<GeoHitWrapper<TProperties, TGeometry>> getHits() {
		return hits;
	}

	public void setHits(List<GeoHitWrapper<TProperties, TGeometry>> hits) {
		this.hits = hits;
	}
	
	@JsonIgnore
	public List<Feature<TProperties, TGeometry>> getSourceList() {
		
		List<Feature<TProperties, TGeometry>> sources = new ArrayList<Feature<TProperties, TGeometry>>();
		
		int total = getTotal();
		for(int i=0; i<total; i++) {
			if (hits.get(i) != null)
				sources.add(hits.get(i).get_source());
		}
		return sources;
	}
}