package es.redmic.models.es.administrative.model;

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
