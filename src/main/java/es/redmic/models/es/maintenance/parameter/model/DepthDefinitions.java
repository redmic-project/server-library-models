package es.redmic.models.es.maintenance.parameter.model;

import java.util.ArrayList;
import java.util.List;

public class DepthDefinitions {
	
	private String path;

	private int leaves = 0;
	
	private Double value;
	
	private List<DataDefinition> dataDefinitions;
	
	
	public DepthDefinitions() {
		dataDefinitions = new ArrayList<DataDefinition>();
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	public List<DataDefinition> getDataDefinitions() {
		return dataDefinitions;
	}

	public void setDataDefinitions(List<DataDefinition> dataDefinitions) {
		this.dataDefinitions = dataDefinitions;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
