package es.redmic.models.es.maintenance.parameter.model;

import java.util.List;

public class Parameter extends ParameterBase {

	private List<ParameterUnit> units;

	public List<ParameterUnit> getUnits() {
		return units;
	}

	public void setUnits(List<ParameterUnit> units) {
		this.units = units;
	}
}