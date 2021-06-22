package es.redmic.models.es.common.dto;

import java.io.IOException;

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


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ElasticSearchNotNullDTO extends SuperDTO {

	@JsonIgnore
	private ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

	JSONCollectionDTO body;
	int total;

	public ElasticSearchNotNullDTO(JSONCollectionDTO data, int total) {
		super(true);

		try {
			// Limpia las propiedades nulas
			this.body = mapper.readValue(mapper.writeValueAsString(data), JSONCollectionDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
			this.body = data;
		}
		this.total = total;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(JSONCollectionDTO result) {
		this.body = result;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
