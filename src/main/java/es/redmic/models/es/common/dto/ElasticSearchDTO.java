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

import java.util.List;

import es.redmic.models.es.geojson.common.dto.GeoJSONFeatureCollectionDTO;

public class ElasticSearchDTO extends SuperDTO {

	Object body;
	int total;

	public ElasticSearchDTO(JSONCollectionDTO result) {
		super(true);
		this.body = result;
		this.total = result.getTotal();
	}
	
	public ElasticSearchDTO(GeoJSONFeatureCollectionDTO result) {
		super(true);
		this.body = result;
		this.total = result.getTotal();
	}
	
	public ElasticSearchDTO(List<?> data) {
		super(true);
		this.body = data;
		this.total = data.size();
	}

	public ElasticSearchDTO(Object data, int total) {
		super(true);
		this.body = data;
		this.total = total;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object result) {
		this.body = result;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
