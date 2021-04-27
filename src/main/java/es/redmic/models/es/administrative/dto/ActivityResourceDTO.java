package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.DTOImplement;

public class ActivityResourceDTO extends DTOImplement {

	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	@Size(min = 0, max = 1500)
	private String description;

	@NotNull
	@Size(min = 1, max = 500)
	private String urlResource;

	public ActivityResourceDTO() {
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

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
