package es.redmic.models.es.maintenance.areas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.common.dto.ClassificationBaseDTO;

public class ThematicTypeBaseDTO extends ClassificationBaseDTO {

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSerialize(as = ThematicTypeBaseDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.THEMATIC_TYPE")
	private ThematicTypeBaseDTO parent;

	public ThematicTypeBaseDTO getParent() {
		return parent;
	}

	public void setParent(ThematicTypeBaseDTO parent) {
		this.parent = parent;
	}
}