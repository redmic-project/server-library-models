package es.redmic.models.es.maintenance.areas.dto;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaFormat;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.common.dto.ClassificationCommonDTO;

public class ThematicTypeDTO extends ClassificationCommonDTO {

	@Size(min = 0, max = 7)
	@JsonSchemaFormat("colour")
	private String colour;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSerialize(as = ThematicTypeDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.THEMATIC_TYPE")
	private ThematicTypeDTO parent;

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public ThematicTypeDTO getParent() {
		return parent;
	}

	public void setParent(ThematicTypeDTO parent) {
		this.parent = parent;
	}
}