package es.redmic.models.es.geojson.area.dto;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.geojson.common.dto.GeoDataRelationDTO;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;
import es.redmic.models.es.maintenance.areas.dto.AreaClassificationDTO;
import es.redmic.models.es.maintenance.areas.dto.AreaTypeDTO;

@JsonSchemaNotNull
public class AreaPropertiesDTO extends PropertiesDTO {

	@JsonSchemaIgnore
	private String path;

	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.AREAS_BY_ACTIVITY")
	private GeoDataRelationDTO parent;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.AREA_TYPE")
	private AreaTypeDTO areaType;

	@Valid
	private List<AreaClassificationDTO> areaClassification;

	@Size(min = 0, max = 250)
	private String code;

	@Size(min = 0, max = 1500)
	private String description;

	private Boolean legalvalidity;

	@NotNull
	@Size(min = 1, max = 250)
	private String name;

	@Size(min = 0, max = 1500)
	private String remark;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public GeoDataRelationDTO getParent() {
		return parent;
	}

	public void setParent(GeoDataRelationDTO parent) {
		this.parent = parent;
	}

	public AreaTypeDTO getAreaType() {
		return areaType;
	}

	public void setAreaType(AreaTypeDTO areaType) {
		this.areaType = areaType;
	}

	public List<AreaClassificationDTO> getAreaClassification() {
		return areaClassification;
	}

	public void setAreaClassification(List<AreaClassificationDTO> areaClassification) {
		this.areaClassification = areaClassification;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getLegalvalidity() {
		return legalvalidity;
	}

	public void setLegalvalidity(Boolean legalvalidity) {
		this.legalvalidity = legalvalidity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
