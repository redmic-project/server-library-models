package es.redmic.models.es.geojson.common.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vividsolutions.jts.geom.Geometry;

import es.redmic.models.es.common.model.HitWrapper;


@JsonIgnoreProperties(ignoreUnknown=true)
public class GeoHitWrapper<TProperties extends Properties, TGeometry extends Geometry> extends HitWrapper {
	
	private String _parent;
	
	private Feature<TProperties, TGeometry> _source;
	
	private InnerHits inner_hits;
	
	public String get_parent() {
		return _parent;
	}

	public void set_parent(String _parent) {
		this._parent = _parent;
	}
	
	public Feature<TProperties, TGeometry> get_source() {
		return _source;
	}

	public void set_source(Feature<TProperties, TGeometry> _source) {
		this._source = _source;
	}

	public InnerHits getInner_hits() {
		return inner_hits;
	}

	public void setInner_hits(InnerHits inner_hits) {
		this.inner_hits = inner_hits;
	}	
}