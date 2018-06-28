package es.redmic.models.es.maintenance.point.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.common.dto.ClassificationBaseDTO;


public class InfrastructureTypeBaseDTO extends ClassificationBaseDTO {

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.INFRASTRUCTURE_TYPE")
	private InfrastructureTypeBaseDTO parent;
	
	public InfrastructureTypeBaseDTO() {
	}

	public InfrastructureTypeBaseDTO getParent() {
		return parent;
	}

	public void setParent(InfrastructureTypeBaseDTO parent) {
		this.parent = parent;
	}
}