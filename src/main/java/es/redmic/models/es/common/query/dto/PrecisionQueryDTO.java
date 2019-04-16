package es.redmic.models.es.common.query.dto;

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

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.constraintvalidate.range.ValidateRange;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@ValidateRange(min="min", max="max")
public class PrecisionQueryDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private Double min;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private Double max;

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}
}
