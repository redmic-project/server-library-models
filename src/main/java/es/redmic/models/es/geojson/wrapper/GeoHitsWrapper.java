package es.redmic.models.es.geojson.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.common.model.HitsWrapper;

public class GeoHitsWrapper<TModel extends BaseES<?>> extends HitsWrapper {

	public GeoHitsWrapper() {
	}

	public GeoHitsWrapper(List<GeoHitWrapper<TModel>> hits) {
		this.hits = hits;
	}

	private List<GeoHitWrapper<TModel>> hits;

	public List<GeoHitWrapper<TModel>> getHits() {
		return hits;
	}

	public void setHits(List<GeoHitWrapper<TModel>> hits) {
		this.hits = hits;
	}

	@JsonIgnore
	public List<TModel> getSourceList() {

		List<TModel> sources = new ArrayList<TModel>();

		int total = getTotal();
		for (int i = 0; i < total; i++) {
			if (hits.get(i) != null)
				sources.add(hits.get(i).get_source());
		}
		return sources;
	}
}