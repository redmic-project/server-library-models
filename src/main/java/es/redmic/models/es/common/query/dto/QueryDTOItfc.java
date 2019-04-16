package es.redmic.models.es.common.query.dto;

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
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public interface QueryDTOItfc {

	public void checkFieldsExcludedOnQuery();

	public void createSimpleQueryDTOFromTextQueryParams(String[] fields, String text, Integer from, Integer size);

	public void createSimpleQueryDTOFromSuggestQueryParams(String[] fields, String text, Integer size);

	public void addAccessibilityIds(List<Long> accessibilities);

	public void setFieldsExcludedOnQuery(Set<String> fieldsExcludedOnQuery);

	public void setFixedQuery(Map<String, Object> fixedQuery);

	public void setDataType(String type);

	@JsonIgnore
	@JsonSchemaIgnore
	public default List<AggsPropertiesDTO> getAggs() {
		return null;
	}

	@JsonIgnore
	@JsonSchemaIgnore
	public default Map<String, String[]> getPostFilter() {
		return null;
	}
}
