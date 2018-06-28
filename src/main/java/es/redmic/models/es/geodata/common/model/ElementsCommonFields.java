package es.redmic.models.es.geodata.common.model;

public class ElementsCommonFields extends BaseAbstractGeoData {

	private String date;
	
	private String qFlag;

	private String vFlag;
	
	private String remark;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getqFlag() {
		return qFlag;
	}

	public void setqFlag(String qFlag) {
		this.qFlag = qFlag;
	}

	public String getvFlag() {
		return vFlag;
	}

	public void setvFlag(String vFlag) {
		this.vFlag = vFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
