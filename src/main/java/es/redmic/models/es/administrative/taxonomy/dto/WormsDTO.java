package es.redmic.models.es.administrative.taxonomy.dto;

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
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
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
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
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
