package es.redmic.models.es.geojson.common.dto;

import es.redmic.models.es.common.dto.DTOImplement;

public class GeoDataRelationDTO extends DTOImplement {

	private String uuid;

	private String activityId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
}
