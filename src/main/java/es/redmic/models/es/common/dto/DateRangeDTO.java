package es.redmic.models.es.common.dto;

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

import es.redmic.models.es.common.constraintvalidate.daterange.ValidateDateRange;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

@ValidateDateRange(start="startDate", end="endDate")
public abstract class DateRangeDTO extends DTOImplement {
	
	private DateTime startDate;

	private DateTime endDate;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getEndDate() {
		return endDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
}
