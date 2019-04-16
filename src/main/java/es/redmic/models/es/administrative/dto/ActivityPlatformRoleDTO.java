package es.redmic.models.es.administrative.dto;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DateRangeDTO;
import es.redmic.models.es.maintenance.administrative.dto.RoleDTO;

@JsonSchemaNotNull
public class ActivityPlatformRoleDTO extends DateRangeDTO {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = PlatformCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.PLATFORM")
	private PlatformCompactDTO platform;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.CONTACT")
	private ContactBaseDTO contact;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.CONTACT_ROLE")
	private RoleDTO role;

	public PlatformCompactDTO getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformCompactDTO platform) {
		this.platform = platform;
	}

	public ContactBaseDTO getContact() {
		return contact;
	}
	
	public void setContact(ContactBaseDTO contact) {
		this.contact = contact;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public RoleDTO getRole() {
		return role;
	}
}
