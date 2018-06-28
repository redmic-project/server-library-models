package es.redmic.models.es.maintenance.parameter.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.administrative.dto.ContactBaseDTO;
import es.redmic.models.es.administrative.dto.ContactDTO;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DomainImplDTO;
import es.redmic.models.es.common.dto.HierarchicalDTO;
import es.redmic.models.es.maintenance.administrative.dto.RoleDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceCompactDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceDTO;

public class DataDefinitionDTO extends HierarchicalDTO {
	
	protected Double z;
	
	private Double deviation;

	@NotNull
	@Size(min = 1, max = 1500)
	private String description;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = DeviceCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DEVICE")
	private DeviceDTO device;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = ContactBaseDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.CONTACT")
	private ContactDTO contact;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = DomainImplDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.CONTACT_ROLE")
	private RoleDTO contactRole;
	
	private Boolean derivedData = false;
	
	private Integer significantDigits;

	private BigDecimal maxValue;

	private BigDecimal minValue;

	@Min(value = 0)
	protected Long timeInterval;

	protected Boolean isSerial = false;

	private Boolean isRegularity = false;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DeviceDTO getDevice() {
		return device;
	}

	public void setDevice(DeviceDTO device) {
		this.device = device;
	}

	public ContactDTO getContact() {
		return contact;
	}

	public void setContact(ContactDTO contact) {
		this.contact = contact;
	}

	public RoleDTO getContactRole() {
		return contactRole;
	}

	public void setContactRole(RoleDTO role) {
		this.contactRole = role;
	}
	
	public Boolean getDerivedData() {
		return derivedData;
	}

	public void setDerivedData(Boolean deriveddata) {
		this.derivedData = deriveddata;
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
