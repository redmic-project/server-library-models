package es.redmic.models.es.series.common.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.SearchWrapper;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SeriesSearchWrapper<TModel extends BaseAbstractES> extends SearchWrapper {
	
	private SeriesHitsWrapper<TModel> hits;

	public SeriesHitsWrapper<TModel> getHits() {
		return hits;
	}

	public void setHits(SeriesHitsWrapper<TModel> hits) {
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
		
		if (hits.getTotal() < 1 || index >= hits.getHits().size())
			return null;
		
		return (TModel) hits.getHits().get(index).get_source();
	}
	
	@JsonIgnore
	public void setSource(int index, TModel source) {
		
		if (hits.getTotal() > index)
			hits.getHits().get(index).set_source(source);
	}
}
