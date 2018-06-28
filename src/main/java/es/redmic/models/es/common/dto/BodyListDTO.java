package es.redmic.models.es.common.dto;

import java.util.List;

public class BodyListDTO <TDto> extends SuperDTO{
	
	private List<TDto> body;

	public BodyListDTO(List<TDto> list) {
		super(true);
		this.body = list;
	}
	
	public List<TDto> getBody() {
		return body;
	}

	public void setBody(List<TDto> list) {
		this.body = list;
	}
}
