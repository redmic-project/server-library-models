package es.redmic.models.es.atlas.model;

import es.redmic.models.es.common.model.BaseHierarchicalAbstractES;

public class LayerModelCompact extends BaseHierarchicalAbstractES {

	private String name;
	
	private String description;
	
	private String alias;
	
	private Boolean atlas;
	
	private Long parentId;
	
	private ThemeInspire themeInspire;

	public LayerModelCompact() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public ThemeInspire getThemeInspire() {
		return themeInspire;
	}

	public void setThemeInspire(ThemeInspire themeInspire) {
		this.themeInspire = themeInspire;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}