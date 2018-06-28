package es.redmic.models.es.administrative.taxonomy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;
import es.redmic.models.es.common.deserializer.CustomDateTimeWOMillisecondsDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class WormsDTO extends WormsBaseDTO {

	@Size(min = 0, max = 150)
	String status;

	@Size(min = 0, max = 200)
	String authority;

	@Size(min = 0, max = 200)
	String validName;

	Integer validAphia;

	@NotNull
	@ValidateUrl
	String url;

	@NotNull
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeWOMillisecondsDeserializer.class)
	private DateTime modified;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@JsonGetter("valid_name")
	public String getValidName() {
		return validName;
	}

	@JsonSetter("valid_name")
	public void setValidName(String validName) {
		this.validName = validName;
	}

	@JsonGetter("valid_AphiaID")
	public Integer getValidAphia() {
		return validAphia;
	}

	@JsonSetter("valid_AphiaID")
	public void setValidAphia(Integer validAphia) {
		this.validAphia = validAphia;
	}

	public DateTime getModified() {
		return modified;
	}

	public void setModified(DateTime modified) {
		this.modified = modified;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
