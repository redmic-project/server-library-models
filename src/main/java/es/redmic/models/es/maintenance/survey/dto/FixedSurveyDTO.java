package es.redmic.models.es.maintenance.survey.dto;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;
import es.redmic.models.es.common.dto.HierarchicalDTO;

public class FixedSurveyDTO extends HierarchicalDTO {

	@NotNull
	@Size(min = 1, max = 50)
	private String code;

	@NotNull
	@Size(min = 1, max = 50)
	private String name;

	@JsonSchemaIgnore
	@Size(min = 2, max = 2)
	private String prefixType;

	@Size(min = 0, max = 250)
	private String description;

	// TODO: añadir @JsonSchemaFormat("url"). Url compleja que no cumple con la
	// validación
	@ValidateUrl
	@Size(min = 0, max = 500)
	private String dashboard;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getPrefixType() {
		return prefixType;
	}

	public void setPrefixType(String prefixType) {
		this.prefixType = prefixType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDashboard() {
		return dashboard;
	}

	public void setDashboard(String dashboard) {
		this.dashboard = dashboard;
	}
}
