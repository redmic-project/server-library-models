package es.redmic.models.es.common.dto;

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

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public class JSONCollectionBaseDTO {
	
	private AggregationsDTO _aggs;
	
	@JsonSchemaIgnore
	private MetaDataCollectionDTO _meta;
	
	private Integer total;

	public JSONCollectionBaseDTO() {
		_meta = new MetaDataCollectionDTO();
		_aggs = new AggregationsDTO();
	}
	
	public AggregationsDTO get_aggs() {
		return _aggs;
	}

	public void set_aggs(AggregationsDTO _aggs) {
		this._aggs = _aggs;
	}

	public MetaDataCollectionDTO get_meta() {
		return _meta;
	}

	public void set_meta(MetaDataCollectionDTO _meta) {
		this._meta = _meta;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
