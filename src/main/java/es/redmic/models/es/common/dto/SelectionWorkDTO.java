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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.query.dto.DataQueryDTO;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SelectionWorkDTO extends SelectionBaseDTO {

	DataQueryDTO query = new DataQueryDTO();

	String action;

	String userId;
	
	List<String> ids;
	
	String idProperty = "id";

	public SelectionWorkDTO() {
	}

	public DataQueryDTO getQuery() {
		return query;
	}

	public void setQuery(DataQueryDTO queryDTO) {
		this.query = queryDTO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	public void addIds(List<String> ids) {
		this.ids.addAll(ids);
	}

	public String getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(String idProperty) {
		this.idProperty = idProperty;
	}
}
