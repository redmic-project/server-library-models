package es.redmic.models.es.geojson.toponym.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geojson.common.model.Properties;

public class ToponymProperties extends Properties {

	private DateTime inserted;
	private DateTime updated;
	
	private String name;
	
	private String description;
	
	private Integer zoomLevel;

	private DomainES toponymType;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getInserted() {
		return inserted;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getUpdated() {
		return updated;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(Integer zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public DomainES getToponymType() {
		return toponymType;
	}

	public void setToponymType(DomainES toponymType) {
		this.toponymType = toponymType;
	}
}
