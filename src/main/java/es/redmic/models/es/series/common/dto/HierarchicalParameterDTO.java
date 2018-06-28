package es.redmic.models.es.series.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.CompactDTO;
import es.redmic.models.es.common.dto.HierarchicalDTO;
import es.redmic.models.es.maintenance.parameter.dto.ParameterTypeDTO;

public class HierarchicalParameterDTO extends HierarchicalDTO implements CompactDTO {
	
	@Size(min = 0, max = 50)
	private String acronym;

	@NotNull
	@Size(min = 1, max = 50)
	private String name;

	@Size(min = 0, max = 50)
	private String name_en;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.PARAMETER_TYPE")
	private ParameterTypeDTO parameterType;


	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return this.name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public ParameterTypeDTO getParameterType() {
		return parameterType;
	}

	public void setParameterType(ParameterTypeDTO parameterType) {
		this.parameterType = parameterType;
	}
}
