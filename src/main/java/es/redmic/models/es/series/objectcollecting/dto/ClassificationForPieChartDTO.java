package es.redmic.models.es.series.objectcollecting.dto;

import java.util.ArrayList;
import java.util.List;

public class ClassificationForPieChartDTO extends ClassificationBaseDTO {
	
	private List<IntervalAggregationDTO> data = new ArrayList<IntervalAggregationDTO>();

	public List<IntervalAggregationDTO> getData() {
		return data;
	}

	public void setData(List<IntervalAggregationDTO> data) {
		this.data = data;
	}

}
