package es.redmic.models.es.administrative.model;

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

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class OrganisationRoles extends BaseAbstractES {

	private OrganisationCompact organisation;
	
	private DomainES role;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime startDate;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime endDate;

	public OrganisationCompact getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationCompact organisation) {
		this.organisation = organisation;
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
