package es.redmic.models.es.common.query.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public class SortDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	private String field;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	private String order;
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
}
