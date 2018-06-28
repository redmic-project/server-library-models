package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaFormat;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.constraintvalidate.phone.ValidatePhoneNumber;
import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.administrative.dto.CountryDTO;
import es.redmic.models.es.maintenance.administrative.dto.OrganisationTypeDTO;

public class OrganisationDTO extends OrganisationCompactDTO {

	@JsonSchemaFormat("url")
	@Size(min = 0, max = 300)
	@ValidateUrl()
	private String webpage;

	@Size(min = 0, max = 1500)
	private String description;

	@Size(min = 0, max = 500)
	private String address;

	@Size(min = 0, max = 1500)
	private String note;

	@JsonSchemaFormat("email")
	@Email
	@Size(min = 0, max = 50)
	private String email;

	@ValidatePhoneNumber
	private String phone;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.COUNTRIES")
	private CountryDTO country;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.ORGANISATION_TYPES")
	private OrganisationTypeDTO organisationType;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	public OrganisationDTO() {
		super();
	}

	@Override
	@Size(min = 1, max = 150)
	public String getName() {
		return name;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

	public OrganisationTypeDTO getOrganisationType() {
		return organisationType;
	}

	public void setOrganisationType(OrganisationTypeDTO organisationtype) {
		this.organisationType = organisationtype;
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
