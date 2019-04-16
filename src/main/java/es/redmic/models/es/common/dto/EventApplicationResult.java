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
import java.util.Map;

public class EventApplicationResult {

	private Boolean success;

	private String exeptionType;

	private Map<String, String> exceptionArguments;

	public EventApplicationResult(Boolean success) {
		this.success = success;
	}

	public EventApplicationResult(String exeptionType) {
		this.success = false;
		this.exeptionType = exeptionType;
	}

	public EventApplicationResult(String exeptionType, Map<String, String> arguments) {
		this.success = false;
		this.exeptionType = exeptionType;
		this.exceptionArguments = arguments;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getExeptionType() {
		return exeptionType;
	}

	public void setExeptionType(String exeptionType) {
		this.exeptionType = exeptionType;
	}

	public Map<String, String> getExceptionArguments() {
		return exceptionArguments;
	}

	public void setExceptionArguments(Map<String, String> exceptionArguments) {
		this.exceptionArguments = exceptionArguments;
	}

	public void addExceptionArgument(String field, String value) {

		if (this.exceptionArguments == null)
			this.exceptionArguments = new HashMap<String, String>();

		this.exceptionArguments.put(field, value);
	}
}
