package es.redmic.models.es.common.model;

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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.geojson.common.model.Aggregations;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SearchWrapper {

	private Long took;
	
	private Boolean timed_out;
	
	private Map<String, Long> _shards;
	
	private Aggregations aggregations;

	public Long getTook() {
		return took;
	}

	public void setTook(Long took) {
		this.took = took;
	}

	public Boolean getTimed_out() {
		return timed_out;
	}

	public void setTimed_out(Boolean timed_out) {
		this.timed_out = timed_out;
	}

	public Map<String, Long> get_shards() {
		return _shards;
	}

	public void set_shards(Map<String, Long> _shards) {
		this._shards = _shards;
	}
	
	public Aggregations getAggregations() {
		return aggregations;
	}

	public void setAggregations(Aggregations _aggs) {
		this.aggregations = _aggs;
	}
}
