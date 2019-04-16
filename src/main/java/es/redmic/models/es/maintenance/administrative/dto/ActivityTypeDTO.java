package es.redmic.models.es.maintenance.administrative.dto;

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
import es.redmic.models.es.common.dto.DomainImplDTO;

public class ActivityTypeDTO extends DomainImplDTO {

	@Size(min = 0, max = 1500)
	private String description;

	@NotNull
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = DomainImplDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ACTIVITY_FIELD")
	private ActivityFieldDTO activityField;

	public ActivityTypeDTO() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ActivityFieldDTO getActivityField() {
		return activityField;
	}

	public void setActivityField(ActivityFieldDTO activityfield) {
		this.activityField = activityfield;
	}
}
