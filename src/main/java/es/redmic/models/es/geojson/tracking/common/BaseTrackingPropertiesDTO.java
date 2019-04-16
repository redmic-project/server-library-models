package es.redmic.models.es.geojson.tracking.common;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceCompactDTO;

public class BaseTrackingPropertiesDTO extends PropertiesDTO {
	
	private Double z;
	
	private Double deviation;
	
	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = DeviceCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	private DeviceCompactDTO device;

	private DateTime date;

	private Double radius;

	private Integer argosId;
	
	private Integer passDuration;

	private Character locationClass;
	
	private Double cumulativeTime;

	private Double cumulativeKm;
	
	private Double hours;
	
	private Double lastDistanceKm;
	
	private Double speedKph;
	
	private Character qFlag = '0';

	private Character vFlag = 'U';

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public Double getDeviation() {
		return deviation;
	}

	public void setDeviation(Double deviation) {
		this.deviation = deviation;
	}

	public DeviceCompactDTO getDevice() {
		return device;
	}

	public void setDevice(DeviceCompactDTO device) {
		this.device = device;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getDate() {
		return date;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setDate(DateTime date) {
		this.date = date;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Integer getArgosId() {
		return argosId;
	}

	public void setArgosId(Integer argosid) {
		this.argosId = argosid;
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

	public void setSpeedKph(Double speeddKph) {
		this.speedKph = speeddKph;
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
}
