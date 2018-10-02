package es.redmic.models.es.geojson.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.common.model.HitWrapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoHitWrapper<TModel extends BaseES<?>> extends HitWrapper {

	private TModel _source;

	public TModel get_source() {
		return _source;
	}

	public void set_source(TModel _source) {
		this._source = _source;
	}
}