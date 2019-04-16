package es.redmic.models.es.administrative.taxonomy.dto;

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

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WormsClassificationDTO extends WormsBaseDTO {

	ObjectMapper mapper = new ObjectMapper();

	WormsClassificationDTO child;

	@JsonAnySetter
	public void parseUnknownProperties(String name, Object value) {

		if (!(value instanceof ArrayList<?>))
			child = mapper.convertValue(value, WormsClassificationDTO.class);
	}

	@JsonIgnore
	public void setChild(WormsClassificationDTO child) {
		this.child = child;
	}

	@JsonIgnore
	public WormsClassificationDTO getChild() {
		return child;
	}

	@JsonIgnore
	public WormsClassificationDTO getItemByRank(String rank) {

		WormsClassificationDTO _child = getChild();
		while (_child != null) {
			if (_child.getRank().toLowerCase().equals(rank.toLowerCase())) {
				return _child;
			}
			_child = _child.getChild();
		}
		return null;
	}

	@JsonIgnore
	public WormsClassificationDTO getParentItemByAphia(Integer aphia) {

		WormsClassificationDTO _parent = this, _child = getChild();
		while (_child != null) {
			if (_child.getAphia().equals(aphia)) {
				return _parent;
			}
			_parent = _child;
			_child = _child.getChild();
		}
		return null;
	}
}
