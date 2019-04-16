package es.redmic.models.es.series.timeseries.dto;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DataHistogramItemDTO {
	
	private String key_as_string;
	
	private DataHistogramStatsDTO value;

	@JsonProperty("date")
	public String getKey_as_string() {
		return key_as_string;
	}

	@JsonSetter("key_as_string")
	public void setKey_as_string(String key_as_string) {
		this.key_as_string = key_as_string;
	}

	public DataHistogramStatsDTO getValue() {
		return value;
	}

	public void setValue(DataHistogramStatsDTO value) {
		this.value = value;
	}
	
	@JsonIgnore
	public boolean hasData() {
		return (key_as_string.isEmpty() || value == null || (value != null && value.getCount() == 0)) ? false : true;
	}
}
