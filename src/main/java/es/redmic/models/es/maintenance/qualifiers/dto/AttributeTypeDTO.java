package es.redmic.models.es.maintenance.qualifiers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.common.dto.ClassificationCommonDTO;

public class AttributeTypeDTO extends ClassificationCommonDTO {

	public AttributeTypeDTO() {
		super();
	}

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.ATTRIBUTE_TYPE")
	AttributeTypeDTO parent;

	public AttributeTypeDTO getParent() {
		return parent;
	}

	public void setParent(AttributeTypeDTO parent) {
		this.parent = parent;
	}
}