package es.redmic.models.es.maintenance.areas.model;

import es.redmic.models.es.maintenance.common.model.ClassificationCommon;

public class ThematicType extends ClassificationCommon {
	
	private String colour;
	
	public ThematicType() {
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
}
