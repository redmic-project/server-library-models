package es.redmic.models.es.administrative.model;

import es.redmic.models.es.common.model.BaseAbstractES;

public class ActivityResource extends BaseAbstractES {

	private String name;

	private String description;

	private String urlResource;

	public ActivityResource() {
		// default constructor
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlResource() {
		return this.urlResource;
	}

	public void setUrlResource(String urlResource) {
		this.urlResource = urlResource;
	}
}
