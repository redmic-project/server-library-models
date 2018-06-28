package es.redmic.models.es.maintenance.objects.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;

public class ObjectCollectingDTO {
	
	@JsonIgnoreProperties(value = {"_meta", "leaves"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.OBJECT_TYPE")
	private ObjectTypeBaseDTO objectType;

	public ObjectTypeBaseDTO getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectTypeBaseDTO objectType) {
		this.objectType = objectType;
	}
}