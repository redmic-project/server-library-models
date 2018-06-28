package es.redmic.models.es.data.common.model;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.common.model.HitWrapper;

public class DataHitWrapper<TModel extends BaseES<?>> extends HitWrapper {
	
	private TModel _source;
	
	public TModel get_source() {
		return _source;
	}

	public void set_source(TModel _source) {
		this._source = _source;
	}
}