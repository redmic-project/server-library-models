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

import es.redmic.models.es.utils.DecimalUtils;

public class WindroseItemDTO {
	
	public WindroseItemDTO(Integer count) {
		setCount(count);
	}
	
	private Double value;
	
	@JsonIgnore
	private Integer count;
	
	public Double getValue() {
		return DecimalUtils.roundDecimals(value);
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public void calculateValue(Integer total) {
		double aux = (double) count/total;
		setValue(aux*100);
	}
}
