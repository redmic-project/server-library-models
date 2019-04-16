package es.redmic.models.es.common.dto;

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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AggregationsDTO {
	
	protected Map<String,Object> attributes = new HashMap<String,Object>();
	
	@JsonIgnore
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@JsonIgnore
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@JsonAnyGetter
    public Map<String,Object> any() {
        return attributes;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
    	attributes.put(name, value);
    }
}
