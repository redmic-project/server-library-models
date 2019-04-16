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
import java.util.List;

public class ObjectClassificationForListDTO {

	private String category;

	private List<ValueDTO> v = new ArrayList<ValueDTO>();
	
	private String path;

	private int leaves = 0;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ValueDTO> getV() {
		return v;
	}

	public void setV(List<ValueDTO> v) {
		this.v = v;
	}
	
	public void initV(int size) {
		for (int i=0; i<size; i++)
			addV(0);
	}
	
	public void addV(Integer value) {
		
		ValueDTO itemValue = new ValueDTO();
		itemValue.setV(value);
		
		v.add(itemValue);
	
	}

	public void setV(Integer pos, Integer value) {
		
		ValueDTO itemValue = new ValueDTO();
		itemValue.setV(value);
		
		v.add(pos, itemValue);
		v.remove(v.size()-1);
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
}
