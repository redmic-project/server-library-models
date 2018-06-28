package es.redmic.models.es.atlas.model;

import es.redmic.models.es.common.model.BaseAbstractES;

public class Protocols extends BaseAbstractES {

	private String type;
	
	private String url;

	public Protocols() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
