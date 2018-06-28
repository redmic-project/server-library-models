package es.redmic.models.es.geojson.properties.model;

import es.redmic.models.es.common.model.Compact;
import es.redmic.models.es.common.model.DomainES;

public class WeatherCondition extends Compact {

	private String acronym;
	
	private DomainES seaConditionType;
	
	public String getAcronym() {
		return acronym;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public DomainES getSeaConditionType() {
		return seaConditionType;
	}
	
	public void setSeaConditionType(DomainES seaConditionType) {
		this.seaConditionType = seaConditionType;
	} 
}
