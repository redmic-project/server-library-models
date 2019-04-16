package es.redmic.models.es.administrative.model;

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

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class Platform extends PlatformCompact {

	private String licence;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	private String description;

	private String contactPhone;

	private DomainES platformType;

	private List<OrganisationContactRoles> contacts;

	private String note;

	private OrganisationCompact organisation;

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public DomainES getPlatformType() {
		return platformType;
	}

	public void setPlatformType(DomainES platformType) {
		this.platformType = platformType;
	}

	public List<OrganisationContactRoles> getContacts() {
		return contacts;
	}

	public void setContacts(List<OrganisationContactRoles> contacts) {
		this.contacts = contacts;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public OrganisationCompact getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationCompact ownership) {
		this.organisation = ownership;
	}

	public Platform() {
		super();
	}
}
