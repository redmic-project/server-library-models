package es.redmic.models.es.geojson.properties.model;

import es.redmic.models.es.geodata.misc.model.TimeSeriesInMeasurements;
import es.redmic.models.es.maintenance.parameter.model.DataDefinition;
import es.redmic.models.es.maintenance.parameter.model.Unit;
import es.redmic.models.es.series.common.model.HierarchicalParameterES;

public class Measurement {
	
	private TimeSeriesInMeasurements data;
	
	private DataDefinition dataDefinition;
	
	private HierarchicalParameterES parameter;
	
	private Unit unit;

	public TimeSeriesInMeasurements getData() {
		return data;
	}

	public void setData(TimeSeriesInMeasurements data) {
		this.data = data;
	}

	public DataDefinition getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinition dataDefinition) {
		this.dataDefinition = dataDefinition;
	}

	public HierarchicalParameterES getParameter() {
		return parameter;
	}

	public void setParameter(HierarchicalParameterES parameter) {
		this.parameter = parameter;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
