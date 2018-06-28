package es.redmic.models.es.administrative.dto;

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
public class ContactOrganisationRoleDTO extends DateRangeDTO {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = ContactBaseDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.CONTACT")
	private ContactBaseDTO contact;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = OrganisationCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ORGANISATION")
	private OrganisationCompactDTO organisation;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.CONTACT_ROLE")
	private RoleDTO role;

	public ContactBaseDTO getContact() {
		return contact;
	}

	public void setContact(ContactBaseDTO contact) {
		this.contact = contact;
	}

	public OrganisationCompactDTO getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationCompactDTO organisation) {
		this.organisation = organisation;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public RoleDTO getRole() {
		return role;
	}
}
