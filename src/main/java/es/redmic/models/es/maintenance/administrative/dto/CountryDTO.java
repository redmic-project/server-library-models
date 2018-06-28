package es.redmic.models.es.maintenance.administrative.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.DomainImplDTO;

public class CountryDTO extends DomainImplDTO {

	@NotNull
	@Size(min = 1, max = 2)
	private String code;

	public CountryDTO() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}