package es.redmic.models.es.common.dto;

import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;

public class UrlDTO {

	public UrlDTO() {
	}

	@ValidateUrl
	public String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
