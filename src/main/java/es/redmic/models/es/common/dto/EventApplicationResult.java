package es.redmic.models.es.common.dto;

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
