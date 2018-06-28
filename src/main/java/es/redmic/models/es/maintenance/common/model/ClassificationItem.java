package es.redmic.models.es.maintenance.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ClassificationItem {

	@JsonIgnoreProperties(value = {"leaves"})
	private ClassificationBase type;

	public ClassificationBase getType() {
		return type;
	}

	public void setType(ClassificationBase type) {
		this.type = type;
	}
}