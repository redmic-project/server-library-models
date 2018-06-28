package es.redmic.models.es.geodata.ancillarydata.model;

import es.redmic.models.es.geodata.common.model.ElementsCommonFields;
import es.redmic.models.es.maintenance.parameter.model.MetricDefinition;

public class Metric extends ElementsCommonFields {
	
	private Double value;
	
	private MetricDefinition metricDefinition;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public MetricDefinition getMetricDefinition() {
		return metricDefinition;
	}

	public void setMetricDefinition(MetricDefinition metricDefinition) {
		this.metricDefinition = metricDefinition;
	}

}
