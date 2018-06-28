package es.redmic.models.es.maintenance.line.model;

import es.redmic.models.es.maintenance.common.model.ClassificationCommon;

public class LineType extends ClassificationCommon {
	
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}