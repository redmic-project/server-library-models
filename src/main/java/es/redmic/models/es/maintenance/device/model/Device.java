package es.redmic.models.es.maintenance.device.model;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.administrative.model.DocumentCompact;
import es.redmic.models.es.administrative.model.PlatformCompact;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class Device extends DeviceCompact {

	private DomainES deviceType;
	private PlatformCompact platform;
	private DocumentCompact document;
	
	private String serialNumber;
	private String description;
	private String note;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime adquisitionDate;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime manufacturedDate;

	private List<Calibration> calibrations;

	public DomainES getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DomainES deviceType) {
		this.deviceType = deviceType;
	}

	public PlatformCompact getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformCompact platform) {
		this.platform = platform;
	}

	public DocumentCompact getDocument() {
		return document;
	}

	public void setDocument(DocumentCompact document) {
		this.document = document;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialnumber) {
		this.serialNumber = serialnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public DateTime getAdquisitionDate() {
		return adquisitionDate;
	}

	public void setAdquisitionDate(DateTime adquisitiondate) {
		this.adquisitionDate = adquisitiondate;
	}

	public DateTime getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(DateTime manufactureddate) {
		this.manufacturedDate = manufactureddate;
	}

	public List<Calibration> getCalibrations() {
		return calibrations;
	}

	public void setCalibrations(List<Calibration> calibrations) {
		this.calibrations = calibrations;
	}
}