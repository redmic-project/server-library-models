package es.redmic.models.es.maintenance.parameter.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DTOImplement;

@JsonSchemaNotNull
public class ParameterUnitDTO extends DTOImplement {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.UNIT")
	private UnitDTO unit;

	public ParameterUnitDTO() {
	}

	public UnitDTO getUnit() {
		return unit;
	}
	
	public void setUnit(UnitDTO unit) {
		this.unit = unit;
	}
}
