package es.redmic.models.es.series.objectcollecting.dto;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class CategoriesDTO {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY) 
	private List<ObjectClassificationForPieChartDTO> categories = new ArrayList<ObjectClassificationForPieChartDTO>();
	
	@JsonIgnore
	private Integer level;

	@JsonIgnore
	Map<String, Integer> index = new HashMap<String, Integer>();
	
	
	public List<ObjectClassificationForPieChartDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<ObjectClassificationForPieChartDTO> categories) {
		this.categories = categories;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Map<String, Integer> getIndex() {
		return index;
	}

	public void setIndex(Map<String, Integer> index) {
		this.index = index;
	}
	
	public void addCategory(String path, String name, Integer value) {
		
		
		String[] pathSplitted = path.split("\\.");
		if (pathSplitted.length > level + 1) {
			
			String id = pathSplitted[level];
			
			Integer it = index.get(id);
			
			if (it != null) {
			
				ObjectClassificationForPieChartDTO category = categories.get(it);
				category.setLevel(level+1);
				category.addCategory(path, name, value);
			}
		}
		else {
			ObjectClassificationForPieChartDTO category = new ObjectClassificationForPieChartDTO();
			category.setName(name);
			category.setValue(value);
			categories.add(category);
			index.put(pathSplitted[pathSplitted.length-1], categories.indexOf(category));
		}
	}
}
