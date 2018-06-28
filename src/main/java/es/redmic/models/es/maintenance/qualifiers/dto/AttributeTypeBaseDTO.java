package es.redmic.models.es.maintenance.qualifiers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.common.dto.ClassificationBaseDTO;

public class AttributeTypeBaseDTO extends ClassificationBaseDTO {

	public AttributeTypeBaseDTO() {
		super();
	}

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.ATTRIBUTE_TYPE")
	AttributeTypeBaseDTO parent;

	public AttributeTypeBaseDTO getParent() {
		return parent;
	}

	public void setParent(AttributeTypeBaseDTO parent) {
		this.parent = parent;
	}
}