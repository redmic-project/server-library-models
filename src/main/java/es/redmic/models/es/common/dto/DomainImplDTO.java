package es.redmic.models.es.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DomainImplDTO extends CompactDTOImpl implements DomainDTO {

	@NotNull
	@Size(min = 1, max = 150)
	private String name_en;

	@Size(min = 1, max = 150)
	@Override
	public String getName() {
		return name;
	}

	public String getName_en() {
		return this.name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
}
