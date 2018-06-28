package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.DTOImplementWithMeta;

public class ContactBaseDTO extends DTOImplementWithMeta {

	@NotNull
	@Size(min = 1, max = 150)
	private String surname;

	@NotNull
	@Size(min = 1, max = 150)
	private String firstname;
	
	@Size(min = 0, max = 250)
	private String image;
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
