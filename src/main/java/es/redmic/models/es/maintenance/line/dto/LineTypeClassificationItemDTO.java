package es.redmic.models.es.maintenance.line.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;

public class LineTypeClassificationItemDTO {
	
	@JsonIgnoreProperties(value = {"_meta", "leaves"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.LINE_TYPE")
	private LineTypeBaseDTO type;

	public LineTypeBaseDTO getType() {
		return type;
	}

	public void setType(LineTypeBaseDTO type) {
		this.type = type;
	}
}