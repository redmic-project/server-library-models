package es.redmic.models.es.common.dto;

public class DTOStringImplement implements DTOString {
	
	String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
