package es.redmic.models.es.series.timeseries.dto;

import java.util.ArrayList;
import java.util.List;

public class DataBaseDTO {

	List<Integer> dataDefinitionIds;
	
	public DataBaseDTO() {
		dataDefinitionIds = new ArrayList<Integer>();
	}
	
	public List<Integer> getDataDefinitionIds() {
		return dataDefinitionIds;
	}

	public void setDataDefinitionIds(List<Integer> dataDefinitionIds) {
		this.dataDefinitionIds = dataDefinitionIds;
	}
}
