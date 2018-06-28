package es.redmic.models.es.common.dto;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

@JsonSchemaNotNull
public interface DTO extends BaseDTO<Long> {

	public Long getId();

	public void setId(Long id);
}
