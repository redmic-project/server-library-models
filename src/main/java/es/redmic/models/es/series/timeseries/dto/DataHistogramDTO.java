package es.redmic.models.es.series.timeseries.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHistogramDTO extends DataBaseDTO {
	
	private Map<String,Double> minValue;
	private Map<String,Double> maxValue;
	private List<DataHistogramItemDTO> data;
	
	public DataHistogramDTO() {
		
		minValue = new HashMap<String, Double>();
		maxValue = new HashMap<String, Double>();
		data = new ArrayList<DataHistogramItemDTO>();
		
		minValue.put("min", Double.POSITIVE_INFINITY);
		minValue.put("max", Double.POSITIVE_INFINITY);
		minValue.put("count", Double.POSITIVE_INFINITY);
		minValue.put("sum", Double.POSITIVE_INFINITY);
		minValue.put("avg", Double.POSITIVE_INFINITY);
		
		maxValue.put("min", Double.NEGATIVE_INFINITY);
		maxValue.put("max", Double.NEGATIVE_INFINITY);
		maxValue.put("count", Double.NEGATIVE_INFINITY);
		maxValue.put("sum", Double.NEGATIVE_INFINITY);
		maxValue.put("avg", Double.NEGATIVE_INFINITY);
	}

	public Map<String, Double> getMinValue() {
		
		if (data.size() == 0)
			return null;
		
		return minValue;
	}

	public void setMinValue(Map<String, Double> minValue) {
		this.minValue = minValue;
	}

	public Map<String, Double> getMaxValue() {
		
		if (data.size() == 0)
			return null;
		
		return maxValue;
	}

	public void setMaxValue(Map<String, Double> maxValue) {
		this.maxValue = maxValue;
	}

	public List<DataHistogramItemDTO> getData() {
		return data;
	}

	public void setData(List<DataHistogramItemDTO> data) {
		this.data = data;
	}
	
	public void setItemData(DataHistogramItemDTO item) {
		
		DataHistogramStatsDTO values = item.getValue();
		if (values != null) { 
			if (values.getMin() != null && values.getMin() < minValue.get("min"))
				minValue.put("min", values.getMin());
			if (values.getMin() != null && values.getMin() > maxValue.get("min"))
				maxValue.put("min", values.getMin());
			if (values.getMax() != null && values.getMax() < minValue.get("max"))
				minValue.put("max", values.getMax());
			if (values.getMax() != null && values.getMax() > maxValue.get("max"))
				maxValue.put("max", values.getMax());
			if (values.getCount() != null && values.getCount() < minValue.get("count"))
				minValue.put("count", values.getCount().doubleValue());
			if (values.getCount() != null && values.getCount() > maxValue.get("count"))
				maxValue.put("count", values.getCount().doubleValue());	
			if (values.getSum() != null && values.getSum() < minValue.get("sum"))
				minValue.put("sum", values.getSum());
			if (values.getSum() != null && values.getSum() > maxValue.get("sum"))
				maxValue.put("sum", values.getSum());
			if (values.getAvg() != null && values.getAvg() < minValue.get("avg"))
				minValue.put("avg", values.getAvg());
			if (values.getAvg() != null && values.getAvg() > maxValue.get("avg"))
				maxValue.put("avg", values.getAvg());
		}
		data.add(item);
	}
}
