package es.redmic.models.es.common.dto;

public class BodyItemDTO <TDto> extends SuperDTO{
	
	private TDto body;

	public BodyItemDTO() {
		super(true);
		this.body = null;
	}
	
	public BodyItemDTO(TDto dto) {
		super(true);
		this.body = dto;
	}
	
	public TDto getBody() {
		return body;
	}

	public void setBody(TDto dto) {
		this.body = dto;
	}
}
