package es.redmic.models.es.series.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.HitWrapper;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SeriesHitWrapper<TModel extends BaseAbstractES> extends HitWrapper {
	
	private String _parent;
	
	private String _routing;
	
	private TModel _source;
	
	public String get_parent() {
		return _parent;
	}

	public void set_parent(String _parent) {
		this._parent = _parent;
	}
	
	public String get_routing() {
		return _routing;
	}

	public void set_routing(String _routing) {
		this._routing = _routing;
	}

	public TModel get_source() {
		return _source;
	}

	public void set_source(TModel _source) {
		this._source = _source;
	}
}