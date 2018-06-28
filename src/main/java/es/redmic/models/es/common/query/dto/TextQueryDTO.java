package es.redmic.models.es.common.query.dto;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public class TextQueryDTO extends BaseTextQueryDTO {
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private String[] highlightFields;

	public TextQueryDTO() {
	}
	
	public String[] getHighlightFields() {
		return highlightFields;
	}

	public void setHighlightFields(String[] highlightFields) {
		this.highlightFields = highlightFields;
	}
}