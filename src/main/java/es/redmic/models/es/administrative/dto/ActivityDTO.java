package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.administrative.dto.ActivityTypeDTO;

public class ActivityDTO extends ActivityBaseDTO {

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonSerialize(as = AncestorActivityDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.PROJECT")
	private AncestorActivityDTO parent;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.ACTIVITY_TYPE")
	private ActivityTypeDTO activityType;

	@JsonSchemaIgnore
	private String activityCategory;

	public ActivityDTO() {
		super();
	}

	public AncestorActivityDTO getParent() {
		return parent;
	}

	public void setParent(AncestorActivityDTO parent) {
		this.parent = parent;
	}

	public ActivityTypeDTO getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityTypeDTO activityType) {
		this.activityType = activityType;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}
}
