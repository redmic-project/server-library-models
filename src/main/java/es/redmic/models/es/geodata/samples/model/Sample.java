package es.redmic.models.es.geodata.samples.model;

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.DomainES;

public class Sample extends BaseAbstractES {

	private Long size;
	
	private String description;
	
	private String remark;
	
	private String image;
	
	private DomainES sampleType;
	
	private String startDate;
	
	private String endDate;

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public DomainES getSampleType() {
		return sampleType;
	}

	public void setSampleType(DomainES sampleType) {
		this.sampleType = sampleType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
