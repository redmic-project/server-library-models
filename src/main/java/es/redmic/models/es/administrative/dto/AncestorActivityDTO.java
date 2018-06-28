package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.CompactDTOImpl;

public class AncestorActivityDTO extends CompactDTOImpl {

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Size(min = 1, max = 500)
	public String getName() {
		return name;
	}
}