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

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public class AggsPropertiesDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	String field;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	String term;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	String nested;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@JsonSchemaDefault("20")
	Integer size;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	Integer minCount = 0;

	public AggsPropertiesDTO() {
	}
	
	public AggsPropertiesDTO(String field) {
		setField(field);
	}
	
	public AggsPropertiesDTO(String field, String term) {
		setField(field);
		setTerm(term);
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getNested() {
		return nested;
	}

	public void setNested(String nested) {
		this.nested = nested;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getMinCount() {
		return minCount;
	}

	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}
}
