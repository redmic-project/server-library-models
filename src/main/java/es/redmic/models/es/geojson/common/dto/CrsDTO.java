package es.redmic.models.es.geojson.common.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

public class CrsDTO {
	
	@NotNull
	private String type;
	
	@Valid
	@NotNull
	private Properties properties;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	@JsonSchemaNotNull
	public class Properties {
		
		@NotNull
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
