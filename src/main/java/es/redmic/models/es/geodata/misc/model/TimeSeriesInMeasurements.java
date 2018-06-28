package es.redmic.models.es.geodata.misc.model;

import es.redmic.models.es.geodata.common.model.ElementsCommonFields;
import es.redmic.models.es.geodata.samples.model.Sample;

public class TimeSeriesInMeasurements extends ElementsCommonFields {

	private double value;
	
	private Sample sample;

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}
}
