package es.redmic.models.es.atlas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;

public class LayerParentDTO extends LayerBaseDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = LayerParentDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.LAYER")
	private LayerDTO parent;
	
	public LayerParentDTO() {
		
	}
	
	public LayerDTO getParent() {
		return parent;
	}
	
	public void setParent(LayerDTO parent) {
		this.parent = parent;
	}
}