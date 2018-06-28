package es.redmic.models.es.administrative.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class ContactRoles extends BaseAbstractES {
	
	private ContactCompact contact;

	private DomainES role;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime startDate;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime endDate;

	public ContactCompact getContact() {
		return contact;
	}

	public void setContact(ContactCompact contact) {
		this.contact = contact;
	}

	public DomainES getRole() {
		return role;
	}

	public void setRole(DomainES role) {
		this.role = role;
	}
	
	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startdate) {
		this.startDate = startdate;
	}
	
	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime enddate) {
		this.endDate = enddate;
	}
}
