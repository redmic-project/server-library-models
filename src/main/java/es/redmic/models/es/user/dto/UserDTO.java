package es.redmic.models.es.user.dto;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
