package es.redmic.models.es.maintenance.line.dto;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.common.dto.ClassificationBaseDTO;


public class LineTypeBaseDTO extends ClassificationBaseDTO {
	
	@Size(min = 0, max = 1500)
	private String remark;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.LINE_TYPE")
	private LineTypeBaseDTO parent;
	
	public LineTypeBaseDTO() {
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LineTypeBaseDTO getParent() {
		return parent;
	}

	public void setParent(LineTypeBaseDTO parent) {
		this.parent = parent;
	}
}