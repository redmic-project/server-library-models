package es.redmic.models.es.geojson.tracking.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ElementTrackingPropertiesDTO extends BaseTrackingPropertiesDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	private Object element;

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
}