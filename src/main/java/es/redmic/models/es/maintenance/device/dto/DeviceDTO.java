package es.redmic.models.es.maintenance.device.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.administrative.dto.DocumentCompactDTO;
import es.redmic.models.es.administrative.dto.DocumentDTO;
import es.redmic.models.es.administrative.dto.PlatformCompactDTO;
import es.redmic.models.es.administrative.dto.PlatformDTO;
import es.redmic.models.es.common.constraintvalidate.daterange.ValidateDateRange;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

@ValidateDateRange(start="manufacturedDate", end="adquisitionDate")
public class DeviceDTO extends DeviceCompactDTO {

	@Size(min = 0, max = 1500)
	private String note;

	@Size(min = 0, max = 1500)
	private String description;

	@Size(min = 0, max = 100)
	private String serialNumber;

	@JsonProperty("adquisitionDate")
	private DateTime adquisitionDate;

	@JsonProperty("manufacturedDate")
	private DateTime manufacturedDate;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = DocumentCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DOCUMENT")
	private DocumentDTO document;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = PlatformCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.PLATFORM")
	private PlatformDTO platform;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<CalibrationDTO> calibrations;

	@NotNull
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DEVICE_TYPE")
	private DeviceTypeDTO deviceType;
	
	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	public DeviceDTO() {

	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getAdquisitionDate() {
		return adquisitionDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setAdquisitionDate(DateTime adquisitiondate) {
		this.adquisitionDate = adquisitiondate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public PlatformDTO getPlatform() {
		return platform;
	}
	
	public void setPlatform(PlatformDTO platform) {
		this.platform = platform;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getManufacturedDate() {
		return manufacturedDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setManufacturedDate(DateTime manufactureddate) {
		this.manufacturedDate = manufactureddate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialnumber) {
		this.serialNumber = serialnumber;
	}

	public List<CalibrationDTO> getCalibrations() {
		return calibrations;
	}

	public void setCalibrations(List<CalibrationDTO> calibrations) {
		this.calibrations = calibrations;
	}

	public DeviceTypeDTO getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceTypeDTO deviceType) {
		this.deviceType = deviceType;
	}

	public DateTime getInserted() {
		return inserted;
	}

	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}
}
