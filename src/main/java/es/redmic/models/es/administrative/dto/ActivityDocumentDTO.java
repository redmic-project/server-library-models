package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DTOImplement;

@JsonSchemaNotNull
public class ActivityDocumentDTO extends DTOImplement {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DOCUMENT")
	private DocumentCompactDTO document;

	public DocumentCompactDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentCompactDTO document) {
		this.document = document;
	}
}