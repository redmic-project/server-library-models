package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DateRangeDTO;
import es.redmic.models.es.maintenance.administrative.dto.RoleDTO;

@JsonSchemaNotNull
public class OrganisationRoleDTO extends DateRangeDTO {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ORGANISATION")
	private OrganisationCompactDTO organisation;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ORGANISATION_ROLES")
	@JsonProperty("role")
	private RoleDTO role;

	public OrganisationCompactDTO getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationCompactDTO organisation) {
		this.organisation = organisation;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}
}
