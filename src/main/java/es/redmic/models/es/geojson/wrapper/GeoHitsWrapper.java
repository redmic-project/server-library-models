package es.redmic.models.es.geojson.wrapper;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
