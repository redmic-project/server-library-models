package es.redmic.models.es.maintenance.parameter.model;

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.maintenance.device.model.DeviceCompact;

public class MetricDefinition extends BaseAbstractES {

	private String name;
	
	private DomainES metricGroup;

	private DeviceCompact device;

	private Unit unit;

	private String description;
	private String acronym;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DomainES getMetricGroup() {
		return metricGroup;
	}

	public void setMetricGroup(DomainES metricGroup) {
		this.metricGroup = metricGroup;
	}

	public DeviceCompact getDevice() {
		return device;
	}

	public void setDevice(DeviceCompact device) {
		this.device = device;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
}