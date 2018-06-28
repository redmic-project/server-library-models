package es.redmic.models.es.atlas.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public class LayerCategoryDTO extends LayerParentDTO {
	
	@Size(min=0, max=1500)
	private String description;
	
	@Size(min=0, max=250)
	private String alias;
	
	@NotNull
	@JsonSchemaDefault(value="false")
	private Boolean atlas;
	
	@JsonSchemaIgnore
	private String path;
	
	@JsonSchemaIgnore
	private Integer leaves;
	
	
	public LayerCategoryDTO() {
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Boolean getAtlas() {
		return atlas;
	}

	public void setAtlas(Boolean atlas) {
		this.atlas = atlas;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public Integer getLeaves() {
		return leaves;
	}

	public void setLeaves(Integer leaves) {
		this.leaves = leaves;
	}
}