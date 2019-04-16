package es.redmic.models.es.maintenance.parameter.dto;

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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;

public class ParameterDTO extends ParameterBaseDTO {

	@NotNull
	@Size(min=1)
	@JsonProperty("units")
	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ParameterUnitDTO> units;

	public ParameterDTO() {
		super();
		units = new ArrayList<ParameterUnitDTO>();
	}

	public List<ParameterUnitDTO> getUnits() {
		return units;
	}

	public void setUnits(List<ParameterUnitDTO> units) {
		this.units = units;
	}

}
