package es.redmic.models.es.maintenance.parameter.model;

import es.redmic.models.es.common.model.BaseAbstractES;

public class ParameterUnit extends BaseAbstractES {

	private Unit unit;

	public ParameterUnit() {

	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
