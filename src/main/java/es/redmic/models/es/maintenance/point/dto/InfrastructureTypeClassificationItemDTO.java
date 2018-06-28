package es.redmic.models.es.maintenance.point.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;

public class InfrastructureTypeClassificationItemDTO {
	
	@JsonIgnoreProperties(value = {"_meta", "leaves"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.INFRASTRUCTURE_TYPE")
	private InfrastructureTypeBaseDTO type;

	public InfrastructureTypeBaseDTO getType() {
		return type;
	}

	public void setType(InfrastructureTypeBaseDTO type) {
		this.type = type;
	}
}