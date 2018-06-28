package es.redmic.models.es.common.query.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public abstract class BaseTextQueryDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	@Size(min=2)
	String text;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	String[] searchFields;

	public BaseTextQueryDTO() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getSearchFields() {
		return searchFields;
	}

	public void setSearchFields(String[] searchFields) {
		this.searchFields = searchFields;
	}
}