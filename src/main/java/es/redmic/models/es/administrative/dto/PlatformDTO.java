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

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.constraintvalidate.phone.ValidatePhoneNumber;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.administrative.dto.PlatformTypeDTO;

public class PlatformDTO extends PlatformCompactDTO {

	@Size(min = 0, max = 1500)
	private String description;

	@Size(min = 0, max = 150)
	private String licence;

	@ValidatePhoneNumber
	private String contactPhone;

	@Size(min = 0, max = 1500)
	private String note;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ContactOrganisationRoleDTO> contacts;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = OrganisationCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ORGANISATION")
	private OrganisationDTO organisation;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.PLATFORM_TYPE")
	private PlatformTypeDTO platformType;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	public PlatformDTO() {
		super();
		this.contacts = new ArrayList<ContactOrganisationRoleDTO>();
	}

	@Size(min = 1, max = 150)
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public OrganisationDTO getOrganisation() {
		return organisation;
	}
	
	public void setOrganisation(OrganisationDTO organisation) {
		this.organisation = organisation;
	}

	public PlatformTypeDTO getPlatformType() {
		return platformType;
	}

	public void setPlatformType(PlatformTypeDTO platformType) {
		this.platformType = platformType;
	}

	public DateTime getInserted() {
		return inserted;
	}

	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public List<ContactOrganisationRoleDTO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactOrganisationRoleDTO> contacts) {
		this.contacts = contacts;
	}
}
