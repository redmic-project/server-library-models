package es.redmic.models.es.maintenance.objects.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.common.dto.ClassificationBaseDTO;


public class ObjectTypeBaseDTO extends ClassificationBaseDTO {
	
	public ObjectTypeBaseDTO() {
	}
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.OBJECT_TYPE")
	ObjectTypeBaseDTO parent;

	public ObjectTypeBaseDTO getParent() {
		return parent;
	}

	public void setParent(ObjectTypeBaseDTO parent) {
		this.parent = parent;
	}
}