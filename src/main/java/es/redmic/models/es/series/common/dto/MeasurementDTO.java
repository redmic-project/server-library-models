package es.redmic.models.es.series.common.dto;

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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;

@JsonSchemaNotNull
public class MeasurementDTO {
	
	@NotNull
	@Valid
	private DataDefinitionSeriesDTO dataDefinition;
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSchemaUrl(value="controller.mapping.UNIT")
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@NotNull
	private UnitDTO unit;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSchemaUrl(value="controller.mapping.PARAMETER")
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@NotNull
	private HierarchicalParameterDTO parameter;
	
	// TODO: cambiar object por dto específico cuando se de el caso.
	@JsonInclude(Include.NON_NULL)
	@JsonSchemaIgnore
	private List<Object> data;

	public DataDefinitionSeriesDTO getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinitionSeriesDTO dataDefinition) {
		this.dataDefinition = dataDefinition;
	}
	
	public HierarchicalParameterDTO getParameter() {
		return parameter;
	}

	public void setParameter(HierarchicalParameterDTO parameter) {
		this.parameter = parameter;
	}
	
	public UnitDTO getUnit() {
		return unit;
	}

	public void setUnit(UnitDTO unit) {
		this.unit = unit;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
}
