package es.redmic.models.es.atlas.dto;

import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.DomainImplDTO;

public class ThemeInspireDTO extends DomainImplDTO {
	
	@Size(min=1, max=50)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
