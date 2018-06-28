package es.redmic.models.es.geojson.properties.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.administrative.model.PlatformCompact;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geodata.common.model.PointCommonFields;
import es.redmic.models.es.maintenance.device.model.DeviceCompact;

public class InTrack extends PointCommonFields {

	private String bearing;
	
	private Integer argosId;
	
	private Integer passDuration;

	private Character locationClass;
	
	private Double cumulativeTime;

	private Double cumulativeKm;
	
	private Double hours;
	
	private Double lastDistanceKm;
	
	private Double speedKph;
	
	private Character qFlag;

	private Character vFlag;
	
	private DeviceCompact device;
	
	private DomainES censingStatus;
	
	private PlatformCompact platform;
	
	private DateTime date;

	public String getBearing() {
		return bearing;
	}

	public void setBearing(String bearing) {
		this.bearing = bearing;
	}

	public Integer getArgosId() {
		return argosId;
	}

	public void setArgosId(Integer argosId) {
		this.argosId = argosId;
	}

	public Integer getPassDuration() {
		return passDuration;
	}

	public void setPassDuration(Integer passDuration) {
		this.passDuration = passDuration;
	}

	public Character getLocationClass() {
		return locationClass;
	}

	public void setLocationClass(Character locationClass) {
		this.locationClass = locationClass;
	}

	public Double getCumulativeTime() {
		return cumulativeTime;
	}

	public void setCumulativeTime(Double cumulativeTime) {
		this.cumulativeTime = cumulativeTime;
	}

	public Double getCumulativeKm() {
		return cumulativeKm;
	}

	public void setCumulativeKm(Double cumulativeKm) {
		this.cumulativeKm = cumulativeKm;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public Double getLastDistanceKm() {
		return lastDistanceKm;
	}

	public void setLastDistanceKm(Double lastDistanceKm) {
		this.lastDistanceKm = lastDistanceKm;
	}

	public Double getSpeedKph() {
		return speedKph;
	}

	public void setSpeedKph(Double speedKph) {
		this.speedKph = speedKph;
	}

	public Character getqFlag() {
		return qFlag;
	}

	public void setqFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	public Character getvFlag() {
		return vFlag;
	}

	public void setvFlag(Character vFlag) {
		this.vFlag = vFlag;
	}

	public DeviceCompact getDevice() {
		return device;
	}

	public void setDevice(DeviceCompact device) {
		this.device = device;
	}

	public DomainES getCensingStatus() {
		return censingStatus;
	}

	public void setCensingStatus(DomainES censingStatus) {
		this.censingStatus = censingStatus;
	}

	public PlatformCompact getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformCompact platform) {
		this.platform = platform;
	}
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getDate() {
		return date;
	}
	
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setDate(DateTime date) {
		this.date = date;
	}
}
