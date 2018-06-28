package es.redmic.models.es.common.query.dto;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public class SuggestQueryDTO extends BaseTextQueryDTO {
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private Integer size;

	public SuggestQueryDTO() {
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}