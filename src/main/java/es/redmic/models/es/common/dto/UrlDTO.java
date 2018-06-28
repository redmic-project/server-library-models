package es.redmic.models.es.common.dto;

import org.hibernate.validator.constraints.URL;

public class UrlDTO {

	public UrlDTO() {
	}

	@URL
	public String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
