package es.redmic.models.es.series.timeseries.dto;

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
