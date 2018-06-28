package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.UuidDTO;

public class PlatformCompactDTO extends UuidDTO {

	@Size(min = 0, max = 250)
	private String image;

	@Size(min = 1, max = 150)
	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}