package es.redmic.models.es.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.redmic.models.es.common.dto.DTOImplement;

public class UserDTO extends DTOImplement {

	@NotNull
	@Size(max = 255)
	@Email
	private String email;

	@JsonProperty("enabled")
	private Boolean enable;

	public UserDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enable;
	}

	public void setEnabled(Boolean enable) {
		this.enable = enable;
	}
}
