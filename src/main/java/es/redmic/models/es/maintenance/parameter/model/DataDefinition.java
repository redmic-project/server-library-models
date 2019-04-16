package es.redmic.models.es.maintenance.parameter.model;

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

import java.math.BigDecimal;

import es.redmic.models.es.administrative.model.ContactCompact;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.model.HierarchicalES;
import es.redmic.models.es.maintenance.device.model.DeviceCompact;

public class DataDefinition extends HierarchicalES {
	
	private Double z;
	
	private Double deviation;

	private Boolean derivedData;

	private String description;

	private Integer significantDigits;

	private BigDecimal maxValue;

	private BigDecimal minValue;

	private DeviceCompact device;

	private ContactCompact contact;

	private DomainES contactRole;

	private Long timeInterval;

	private Boolean isSerial;

	private Boolean isRegularity;

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

	public Boolean getDerivedData() {
		return derivedData;
	}

	public void setDerivedData(Boolean deriveddata) {
		this.derivedData = deriveddata;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxvalue) {
		this.maxValue = maxvalue;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minvalue) {
		this.minValue = minvalue;
	}

	public Integer getSignificantDigits() {
		return significantDigits;
	}

	public void setSignificantDigits(Integer significantdigits) {
		this.significantDigits = significantdigits;
	}

	public DeviceCompact getDevice() {
		return device;
	}

	public void setDevice(DeviceCompact device) {
		this.device = device;
	}

	public ContactCompact getContact() {
		return contact;
	}

	public void setContact(ContactCompact contact) {
		this.contact = contact;
	}

	public DomainES getContactRole() {
		return contactRole;
	}

	public void setContactRole(DomainES contactRole) {
		this.contactRole = contactRole;
	}

	public Long getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(Long timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Boolean getIsSerial() {
		return isSerial;
	}

	public void setIsSerial(Boolean isSerial) {
		this.isSerial = isSerial;
	}

	public Boolean getIsRegularity() {
		return this.isRegularity;
	}

	public void setIsRegularity(Boolean regularity) {
		this.isRegularity = regularity;
	}
}
