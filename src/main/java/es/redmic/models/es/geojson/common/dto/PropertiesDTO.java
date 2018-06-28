package es.redmic.models.es.geojson.common.dto;

import javax.validation.constraints.Size;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public class PropertiesDTO extends UpdatablePropertiesDTO {

	@JsonSchemaIgnore
	@Size(min = 1, max = 150)
	private String activityId;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
}
