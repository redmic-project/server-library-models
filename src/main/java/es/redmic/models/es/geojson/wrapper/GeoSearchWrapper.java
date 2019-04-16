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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.common.model.SearchWrapper;

public class GeoSearchWrapper<TModel extends BaseES<?>> extends SearchWrapper {

	private GeoHitsWrapper<TModel> hits;

	public GeoHitsWrapper<TModel> getHits() {
		return hits;
	}

	public void setHits(GeoHitsWrapper<TModel> hits) {
		this.hits = hits;
	}

	@JsonIgnore
	public Integer getTotal() {
		return getHits() != null ? getHits().getTotal() : 0;
	}

	@JsonIgnore
	public List<TModel> getSourceList() {
		return hits.getSourceList();
	}

	@JsonIgnore
	public TModel getSource(int index) {

		if (hits.getTotal() < 1)
			return null;
		return hits.getHits().get(index).get_source();
	}

	@JsonIgnore
	public void setSource(int index, TModel source) {

		if (hits.getTotal() > index)
			hits.getHits().get(index).set_source(source);
	}
}
