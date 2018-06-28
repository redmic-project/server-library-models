package es.redmic.models.es.maintenance.point.model;

import es.redmic.models.es.maintenance.common.model.ClassificationCommon;

public class InfrastructureType extends ClassificationCommon {
	
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}