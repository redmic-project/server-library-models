package es.redmic.models.es.maintenance.parameter.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;

public class ParameterDTO extends ParameterBaseDTO {

	@NotNull
	@Size(min=1)
	@JsonProperty("units")
	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ParameterUnitDTO> units;

	public ParameterDTO() {
		super();
		units = new ArrayList<ParameterUnitDTO>();
	}

	public List<ParameterUnitDTO> getUnits() {
		return units;
	}

	public void setUnits(List<ParameterUnitDTO> units) {
		this.units = units;
	}

}
