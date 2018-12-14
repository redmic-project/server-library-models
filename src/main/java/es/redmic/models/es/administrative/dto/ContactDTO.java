package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaFormat;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.constraintvalidate.phone.ValidatePhoneNumber;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class ContactDTO extends ContactBaseDTO {

	@JsonSchemaFormat("email")
	@Email
	@Size(min = 0, max = 50)
	private String email;

	@ValidatePhoneNumber
	private String phone;

	@ValidatePhoneNumber
	private String mobile;

	@Size(min = 0, max = 1500)
	private String note;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSerialize(as = OrganisationCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.ORGANISATION")
	private OrganisationDTO affiliation;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	public ContactDTO() {
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setAffiliation(OrganisationDTO affiliation) {
		this.affiliation = affiliation;
	}

	public OrganisationDTO getAffiliation() {
		return affiliation;
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
