package es.redmic.models.es.maintenance.objects.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ObjectCollecting {

	@JsonIgnoreProperties(value = {"leaves"})
	private ObjectTypeBase objectType;

	public ObjectTypeBase getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectTypeBase objectType) {
		this.objectType = objectType;
	}
}
