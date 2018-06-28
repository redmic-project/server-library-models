package es.redmic.models.es.administrative.dto;

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

import es.redmic.models.es.common.constraintvalidate.daterange.ValidateDateRange;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.administrative.dto.ScopeDTO;
import es.redmic.models.es.maintenance.common.dto.AccessibilityDTO;

@ValidateDateRange(start="startDate", end="endDate")
public class ActivityBaseDTO extends AncestorActivityDTO {

	public ActivityBaseDTO() {
		super();
		this.organisations = new ArrayList<OrganisationRoleDTO>();
		this.contacts = new ArrayList<ContactOrganisationRoleDTO>();
		this.documents = new ArrayList<ActivityDocumentDTO>();
		this.platforms = new ArrayList<ActivityPlatformRoleDTO>();
	}
	
	@JsonSchemaIgnore
	private String path;

	@Size(min = 0, max = 25)
	private String code;

	@Size(min = 0, max = 1500)
	private String description;

	@NotNull
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime startDate;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime endDate;

	@Size(min = 0, max = 1500)
	private String note;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ACCESSIBILITY")
	private AccessibilityDTO accessibility;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.SCOPES")
	private ScopeDTO scope;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ActivityDocumentDTO> documents;

	// TODO Pending to create Embargo.
	// private EmbargoDTO embargo;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ActivityPlatformRoleDTO> platforms;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ContactOrganisationRoleDTO> contacts;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<OrganisationRoleDTO> organisations;

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

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime enddate) {
		this.endDate = enddate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startdate) {
		this.startDate = startdate;
	}

	public AccessibilityDTO getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(AccessibilityDTO accessibility) {
		this.accessibility = accessibility;
	}

	public ScopeDTO getScope() {
		return scope;
	}

	public void setScope(ScopeDTO scope) {
		this.scope = scope;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public List<OrganisationRoleDTO> getOrganisations() {
		return organisations;
	}

	public void setOrganisations(List<OrganisationRoleDTO> organisations) {
		this.organisations = organisations;
	}

	public List<ContactOrganisationRoleDTO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactOrganisationRoleDTO> contacts) {
		this.contacts = contacts;
	}

	public List<ActivityDocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<ActivityDocumentDTO> documents) {
		this.documents = documents;
	}

	public List<ActivityPlatformRoleDTO> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<ActivityPlatformRoleDTO> platforms) {
		this.platforms = platforms;
	}

	public DateTime getInserted() {
		return inserted;
	}

	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}
}