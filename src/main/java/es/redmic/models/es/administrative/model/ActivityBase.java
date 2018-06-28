package es.redmic.models.es.administrative.model;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBase extends ActivityReferences {

	private DomainES accessibility;

	private String description;

	private List<ActivityDocument> documents;

	private List<ContactOrganisationRoles> contacts;

	private List<OrganisationRoles> organisations;

	private List<PlatformContactRoles> platforms;

	private String note;

	private DomainES scope;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime startDate;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	public ActivityBase() {
		super();
	}

	public DomainES getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(DomainES accessibility) {
		this.accessibility = accessibility;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ActivityDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<ActivityDocument> documents) {
		this.documents = documents;
	}

	public List<ContactOrganisationRoles> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactOrganisationRoles> contacts) {
		this.contacts = contacts;
	}

	public List<OrganisationRoles> getOrganisations() {
		return organisations;
	}

	public void setOrganisations(List<OrganisationRoles> organisations) {
		this.organisations = organisations;
	}

	public List<PlatformContactRoles> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<PlatformContactRoles> platforms) {
		this.platforms = platforms;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DomainES getScope() {
		return scope;
	}

	public void setScope(DomainES scope) {
		this.scope = scope;
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startdate) {
		this.startDate = startdate;
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
}