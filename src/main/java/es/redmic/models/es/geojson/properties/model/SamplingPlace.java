package es.redmic.models.es.geojson.properties.model;

import java.util.List;

import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.geodata.common.model.BaseAbstractGeoData;
import es.redmic.models.es.maintenance.areas.model.AreaClassification;
import es.redmic.models.es.maintenance.common.model.ClassificationItem;

public class SamplingPlace extends BaseAbstractGeoData {

	private String path;

	private String name;

	private String code;

	private String description;

	private String remark;

	private String startDate;

	private String endDate;

	private DomainES areaType;

	private List<AreaClassification> areaClassification;

	private List<ClassificationItem> classification;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public DomainES getAreaType() {
		return areaType;
	}

	public void setAreaType(DomainES areaType) {
		this.areaType = areaType;
	}

	public List<AreaClassification> getAreaClassification() {
		return areaClassification;
	}

	public void setAreaClassification(List<AreaClassification> areaClassification) {
		this.areaClassification = areaClassification;
	}

	public List<ClassificationItem> getClassification() {
		return classification;
	}

	public void setClassification(List<ClassificationItem> classification) {
		this.classification = classification;
	}
}
