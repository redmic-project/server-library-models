package es.redmic.models.es.administrative.model;

import es.redmic.models.es.common.model.UuidModel;

public class PlatformCompact extends UuidModel {

	private String name;
	private String image;

	public PlatformCompact() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
