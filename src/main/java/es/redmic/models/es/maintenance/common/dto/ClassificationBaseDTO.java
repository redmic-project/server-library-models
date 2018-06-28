package es.redmic.models.es.maintenance.common.dto;

import javax.validation.constraints.Size;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

import es.redmic.models.es.common.dto.DomainImplDTO;

public abstract class ClassificationBaseDTO extends DomainImplDTO {

	@Size(min = 0, max = 50)
	private String code;
	
	@JsonSchemaIgnore
	private Integer level;
	
	@JsonSchemaIgnore
	private String path;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
