package es.redmic.models.es.maintenance.parameter.model;

import java.util.ArrayList;
import java.util.List;

public class ParametersTimeSeries extends ParameterBase {
	
	private String path;

	private int leaves = 0;
	
	private List<DepthDefinitions> z;
	
	public ParametersTimeSeries() {
		z = new ArrayList<DepthDefinitions>();
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

	public List<DepthDefinitions> getZ() {
		return z;
	}

	public void setZ(List<DepthDefinitions> z) {
		this.z = z;
	}
}
