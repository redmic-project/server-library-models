package es.redmic.models.es.geojson.common.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Aggregations {
	
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
