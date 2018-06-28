package es.redmic.models.es.maintenance.survey.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

import es.redmic.models.es.common.dto.HierarchicalDTO;

public class FixedSurveyDTO extends HierarchicalDTO {

	@NotNull
	@Size(min = 1, max = 50)
	private String code;

	@NotNull
	@Size(min = 1, max = 50)
	private String name;

	@JsonSchemaIgnore
	@Size(min = 2, max = 2)
	private String prefixType;

	@Size(min = 0, max = 250)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getPrefixType() {
		return prefixType;
	}

	public void setPrefixType(String prefixType) {
		this.prefixType = prefixType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
