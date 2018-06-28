package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DomainImplDTO;
import es.redmic.models.es.maintenance.administrative.dto.ProjectGroupDTO;

public class ProjectDTO extends ActivityBaseDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = AncestorActivityDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.PROGRAM")
	private AncestorActivityDTO parent;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = DomainImplDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.PROJECT_GROUPS")
	private ProjectGroupDTO projectGroup;

	public ProjectDTO() {
		super();
	}
	
	public AncestorActivityDTO getParent() {
		return parent;
	}

	public void setParent(AncestorActivityDTO parent) {
		this.parent = parent;
	}

	public ProjectGroupDTO getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(ProjectGroupDTO projectGroup) {
		this.projectGroup = projectGroup;
	}
}