package es.redmic.models.es.geodata.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.BaseES;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BaseAbstractGeoData implements BaseES<String> {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
