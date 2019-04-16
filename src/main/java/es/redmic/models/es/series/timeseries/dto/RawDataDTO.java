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

import java.util.ArrayList;
import java.util.List;

public class RawDataDTO extends DataBaseDTO {
	
	private Double minValue;
	private Double maxValue;
	
	private List<RawDataItemDTO> data;
	
	public RawDataDTO() {
		
		minValue = Double.POSITIVE_INFINITY;
		maxValue = Double.NEGATIVE_INFINITY;
		data = new ArrayList<RawDataItemDTO>();
	}

	public Double getMinValue() {
		
		if (data.size() == 0)
			return null;
		
		return minValue;
	}
	
	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}
	
	public Double getMaxValue() {
		
		if (data.size() == 0)
			return null;
		
		return maxValue;
	}
	
	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public List<RawDataItemDTO> getData() {
		return data;
	}

	public void setData(List<RawDataItemDTO> data) {
		this.data = data;
	}

	public void setItemData(RawDataItemDTO item) {
		Double value = item.getValue();
		if ((value != null) && (value < minValue))
			minValue = value;
		if ((value != null) && (value > maxValue))
			maxValue = value;
		data.add(item);
	}
}
