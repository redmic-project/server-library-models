package es.redmic.models.es.administrative.dto;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 - 2021 REDMIC Project / Server
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
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DTOImplement;
import es.redmic.models.es.maintenance.administrative.dto.ResourceTypeDTO;

public class ActivityResourceDTO extends DTOImplement {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.RESOURCE_TYPE")
	private ResourceTypeDTO resourceType;

	@NotNull
	@Size(min = 1, max = 500)
	private String urlResource;

	public ActivityResourceDTO() {
		// default constructor
	}

	public ResourceTypeDTO getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(ResourceTypeDTO resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrlResource() {
		return this.urlResource;
	}

	public void setUrlResource(String urlResource) {
		this.urlResource = urlResource;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
