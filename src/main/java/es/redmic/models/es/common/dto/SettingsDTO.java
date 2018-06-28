package es.redmic.models.es.common.dto;

public class SettingsDTO implements BaseDTO<String> {

	String id;

	public SettingsDTO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
