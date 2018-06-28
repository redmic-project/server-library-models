package es.redmic.models.es.series.common.dto;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

import es.redmic.models.es.common.dto.DTOImplementWithMeta;

public abstract class SeriesCommonDTO extends DTOImplementWithMeta {

	@JsonSchemaIgnore
	private String _parentId;

	@JsonSchemaIgnore
	private String _grandparentId;

	// Notas
	@Size(min = 0, max = 1500)
	private String remark;

	private Character qFlag = '0';

	private Character vFlag = 'U';

	public String get_parentId() {
		return _parentId;
	}

	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}

	public String get_grandparentId() {
		return _grandparentId;
	}

	public void set_grandparentId(String _grandparentId) {
		this._grandparentId = _grandparentId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@JsonProperty(value = "qFlag")
	public Character getQFlag() {
		return qFlag;
	}

	@JsonProperty(value = "qFlag")
	public void setQFlag(Character qFlag) {

		if (qFlag != null)
			this.qFlag = qFlag;
	}

	@JsonIgnore
	public void setqFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	@JsonProperty(value = "vFlag")
	public Character getVFlag() {
		return vFlag;
	}

	@JsonProperty(value = "vFlag")
	public void setVFlag(Character vFlag) {

		if (vFlag != null)
			this.vFlag = vFlag;
	}

	@JsonIgnore
	public void setvFlag(Character vFlag) {
		this.vFlag = vFlag;
	}
}
