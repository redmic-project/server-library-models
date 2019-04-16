package es.redmic.models.es.geojson.infrastructure.dto;

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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaFormat;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;
import es.redmic.models.es.maintenance.point.dto.InfrastructureTypeBaseDTO;
import es.redmic.models.es.series.attributeseries.dto.AttributeSeriesDTO;

@JsonSchemaNotNull
public class InfrastructurePropertiesDTO extends PropertiesDTO {

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime date;

	@NotNull
	@JsonIgnoreProperties(value = { "_meta" })
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.INFRASTRUCTURE_TYPE")
	private InfrastructureTypeBaseDTO infrastructureType;

	@JsonSchemaIgnore
	private List<AttributeSeriesDTO> attributes;

	private Double rotate;

	private Double z;

	@Size(min = 0, max = 1500)
	private String description;

	@Size(min = 0, max = 250)
	private String name;

	@Size(min = 0, max = 1500)
	private String remark;

	@NotNull
	@Size(min = 1, max = 50)
	private String code;

	@JsonSchemaFormat("url")
	@ValidateUrl()
	@Size(min = 0, max = 500)
	private String url;

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public InfrastructureTypeBaseDTO getInfrastructureType() {
		return infrastructureType;
	}

	public void setInfrastructureType(InfrastructureTypeBaseDTO infrastructureType) {
		this.infrastructureType = infrastructureType;
	}

	public List<AttributeSeriesDTO> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributeSeriesDTO> attributes) {
		this.attributes = attributes;
	}

	public Double getRotate() {
		return rotate;
	}

	public void setRotate(Double rotate) {
		this.rotate = rotate;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
