package es.redmic.models.es.series.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.redmic.models.es.common.model.BaseAbstractES;

public abstract class SeriesCommon extends BaseAbstractES {
	
	private String _parentId;
	
	private String _grandparentId;

	private Character qFlag = '0';

	private Character vFlag = 'U';
	
	private String remark;
	
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
	
	@JsonProperty(value="qFlag")
	public Character getQFlag() {
		return qFlag;
	}

	public void setQFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	@JsonProperty(value="vFlag")
	public Character getVFlag() {
		return vFlag;
	}

	public void setVFlag(Character vFlag) {
		this.vFlag = vFlag;
	}
	
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
