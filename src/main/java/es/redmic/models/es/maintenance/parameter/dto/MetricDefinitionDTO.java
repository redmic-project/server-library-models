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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.CompactDTOImpl;
import es.redmic.models.es.maintenance.ancillary.dto.MetricGroupDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceCompactDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceDTO;

public class MetricDefinitionDTO extends CompactDTOImpl {

	@Size(min = 0, max = 50)
	private String acronym;

	@Size(min = 0, max = 1500)
	private String description;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = DeviceCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DEVICE")
	private DeviceDTO device;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.METRIC_GROUP")
	private MetricGroupDTO metricGroup;
	
	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.UNIT")
	private UnitDTO unit;

	public MetricDefinitionDTO() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UnitDTO getUnit() {
		return unit;
	}

	public void setUnit(UnitDTO unit) {
		this.unit = unit;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public DeviceDTO getDevice() {
		return device;
	}

	public void setDevice(DeviceDTO device) {
		this.device = device;
	}

	public MetricGroupDTO getMetricGroup() {
		return metricGroup;
	}
	
	public void setMetricGroup(MetricGroupDTO metricGroup) {
		this.metricGroup = metricGroup;
	}
	
	@Size(min = 1, max = 150)
	@Override
	public String getName() {
		return name;
	}
}
