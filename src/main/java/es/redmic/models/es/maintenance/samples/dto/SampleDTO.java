package es.redmic.models.es.maintenance.samples.dto;

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

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.CompactDTOImpl;
import es.redmic.models.es.common.dto.DomainImplDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceDTO;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;

public class SampleDTO extends CompactDTOImpl {

	@Size(min = 0, max = 1500)
	private String description;

	@Min(value = 0)
	private Integer fixedareaid;

	@Size(min = 0, max = 250)
	private String image;

	@Size(min = 0, max = 1500)
	private String note;

	@Min(value = 0)
	private BigDecimal value;

	@JsonSerialize(as = DomainImplDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.SAMPLE_TYPE")
	private SampleTypeDTO sampletype;

	@JsonSerialize(as = CompactDTOImpl.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DEVICE")
	private DeviceDTO device;

	@JsonSerialize(as = CompactDTOImpl.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.UNIT")
	private UnitDTO unit;

	public SampleDTO() {

	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonGetter("fixedArea")
	public Integer getFixedareaid() {
		return fixedareaid;
	}

	@JsonSetter("fixedArea")
	public void setFixedareaid(Integer fixedareaid) {
		this.fixedareaid = fixedareaid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public SampleTypeDTO getSampletype() {
		return sampletype;
	}

	public void setSampletype(SampleTypeDTO sampletype) {
		this.sampletype = sampletype;
	}

	public DeviceDTO getDevice() {
		return device;
	}

	public void setDevice(DeviceDTO device) {
		this.device = device;
	}

	public UnitDTO getUnit() { 
		return unit;
	}
	
	public void setUnit(UnitDTO unit) {
		this.unit = unit; 
	}
}
