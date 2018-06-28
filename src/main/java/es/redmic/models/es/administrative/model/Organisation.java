package es.redmic.models.es.administrative.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.administrative.model.Country;

public class Organisation extends OrganisationCompact {

	private String phone;

	private DomainES organisationType;

	private Country country;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	private String webpage;

	private String address;

	private String email;

	private String description;

	private String note;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public DomainES getOrganisationType() {
		return organisationType;
	}

	public void setOrganisationType(DomainES organisationType) {
		this.organisationType = organisationType;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Organisation() {
		super();
	}
}
