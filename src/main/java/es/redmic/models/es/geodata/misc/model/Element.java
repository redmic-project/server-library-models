package es.redmic.models.es.geodata.misc.model;

import java.util.List;

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.geodata.ancillarydata.model.Analytic;
import es.redmic.models.es.geodata.ancillarydata.model.Metric;
import es.redmic.models.es.geodata.common.model.Media;
import es.redmic.models.es.geodata.genomics.model.Molecular;
import es.redmic.models.es.geodata.qualifiers.model.Attribute;

public class Element extends BaseAbstractES{
	
	private String registerNumber;
	
	private List<Media> media;

	private List<Analytic> analytics;
	
	private List<Attribute> attributes;
	
	private List<Metric> metrics;
	
	private List<Molecular> molecular;

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public List<Analytic> getAnalytics() {
		return analytics;
	}

	public void setAnalytics(List<Analytic> analytics) {
		this.analytics = analytics;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	public List<Molecular> getMolecular() {
		return molecular;
	}

	public void setMolecular(List<Molecular> molecular) {
		this.molecular = molecular;
	}
}
