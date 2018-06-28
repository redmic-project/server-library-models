package es.redmic.models.es.data.common.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.common.model.SearchWrapper;

public class DataSearchWrapper<TModel extends BaseES<?>> extends SearchWrapper {
	
	private DataHitsWrapper<TModel> hits;

	public DataHitsWrapper<TModel> getHits() {
		return hits;
	}

	public void setHits(DataHitsWrapper<TModel> hits) {
		this.hits = hits;
	}
	
	@JsonIgnore
	public Integer getTotal() {
		return getHits().getTotal();
	}

	@JsonIgnore
	public List<TModel> getSourceList() {
		return hits.getSourceList();
	}
	
	@JsonIgnore
	public TModel getSource(int index) {
		
		if (hits.getTotal() < 1)
			return null;
		return (TModel) hits.getHits().get(index).get_source();
	}
	
	@JsonIgnore
	public void setSource(int index, TModel source) {
		
		if (hits.getTotal() > index)
			hits.getHits().get(index).set_source(source);
	}
}
