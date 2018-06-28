package es.redmic.models.es.common.dto;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public abstract class HierarchicalDTO extends DTOImplement {

	@JsonSchemaIgnore
	private String path;

	@JsonSchemaIgnore
	private int leaves = 0;

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
}
