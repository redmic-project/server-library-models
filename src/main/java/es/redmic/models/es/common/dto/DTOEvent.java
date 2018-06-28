package es.redmic.models.es.common.dto;

import org.springframework.context.ApplicationEvent;

public class DTOEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private String eventType;

	private DTO dto;

	public DTOEvent(Object source, String eventType, DTO dto) {
		super(source);
		this.setEventType(eventType);
		this.setDto(dto);
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public DTO getDto() {
		return dto;
	}

	public void setDto(DTO dto) {
		this.dto = dto;
	}
}
