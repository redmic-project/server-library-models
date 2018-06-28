package es.redmic.models.es.maintenance.quality.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.DTOStringImplement;

public class QFlagDTO extends DTOStringImplement {

	@NotNull
	@Size(min = 1, max = 150)
	private String name;

	@NotNull
	@Size(min = 1, max = 150)
	private String name_en;

	public QFlagDTO() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
}