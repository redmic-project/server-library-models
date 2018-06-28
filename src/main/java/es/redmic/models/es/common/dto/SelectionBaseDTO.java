package es.redmic.models.es.common.dto;

public class SelectionBaseDTO extends SettingsDTO {
	
	String name;
	String service;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

}
