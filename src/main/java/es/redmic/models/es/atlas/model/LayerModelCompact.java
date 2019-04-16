package es.redmic.models.es.atlas.model;

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
