package es.redmic.models.es.atlas.dto;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

import es.redmic.models.es.common.dto.DTOImplementWithMeta;

public class LayerBaseDTO extends DTOImplementWithMeta {
	
	@JsonSchemaIgnore
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
