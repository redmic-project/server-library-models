package es.redmic.models.es.common.query.dto;

import java.util.Map;

public class FilterSchemaDTO {
	
	private Map<String,Object> schema;

	public Map<String,Object> getSchema() {
		return schema;
	}

	public void setSchema(Map<String,Object> schema) {
		this.schema = schema;
	}
}
