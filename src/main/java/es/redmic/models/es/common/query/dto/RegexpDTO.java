package es.redmic.models.es.common.query.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public class RegexpDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	String field;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	String exp;

	public RegexpDTO() {
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}
}