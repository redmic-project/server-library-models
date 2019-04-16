package es.redmic.models.es.common.dto;

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

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class ErrorTypeDTO {
	
	private String code;
	private String description;
	private HashMap<String, String> fieldErrors;
	
	public ErrorTypeDTO() {
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String codeS) {
		code = codeS;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String descriptionS) {
		description = descriptionS;
	}

	public HashMap<String, String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(HashMap<String, String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
