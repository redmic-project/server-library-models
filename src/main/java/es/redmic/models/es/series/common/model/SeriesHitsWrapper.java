package es.redmic.models.es.series.common.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.HitsWrapper;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SeriesHitsWrapper<TModel extends BaseAbstractES> extends HitsWrapper {
	
	public SeriesHitsWrapper() {
	}
	
	public SeriesHitsWrapper(List<SeriesHitWrapper<TModel>> hits) {
		this.hits = hits;
	}
	
	private List<SeriesHitWrapper<TModel>> hits;

	public List<SeriesHitWrapper<TModel>> getHits() {
		return hits;
	}

	public void setHits(List<SeriesHitWrapper<TModel>> hits) {
		this.hits = hits;
	}
	
	@JsonIgnore
	public List<TModel> getSourceList() {
		
		List<TModel> sources = new ArrayList<TModel>();
		
		int total = getTotal();
		for(int i=0; i<total; i++) {
			if (hits.get(i) != null)
				sources.add(hits.get(i).get_source());
		}
		return sources;
	}
}
