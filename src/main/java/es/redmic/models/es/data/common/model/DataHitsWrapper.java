package es.redmic.models.es.data.common.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.common.model.HitsWrapper;

public class DataHitsWrapper<TModel extends BaseES<?>> extends HitsWrapper {
	
	public DataHitsWrapper() {
	}
	
	public DataHitsWrapper(List<DataHitWrapper<TModel>> hits) {
		setHits(hits);
	}
	
	private List<DataHitWrapper<TModel>> hits;

	public List<DataHitWrapper<TModel>> getHits() {
		return hits;
	}

	public void setHits(List<DataHitWrapper<TModel>> hits) {
		this.hits = hits;
	}
	
	@JsonIgnore
	public List<TModel> getSourceList() {
		
		List<TModel> sources = new ArrayList<TModel>();
		
		if (hits == null)
			return sources;
		
		int total = hits.size();
		for(int i=0; i<total; i++) {
			if (hits.get(i) != null)
				sources.add(hits.get(i).get_source());
		}
		return sources;
	}
}
