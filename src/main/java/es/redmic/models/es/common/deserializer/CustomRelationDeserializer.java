package es.redmic.models.es.common.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomRelationDeserializer extends CustomObjectBaseDeserializer {
	
	@Override
	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		String input = jp.getValueAsString();
		
		if (input != null) {
			Long id = null;
			try {
				id = Long.parseLong(input);
			}
			catch(Exception e){}
			
			if ( id != null) {
				ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.readValue("{\"id\":" +id+ "}", targetClass);
			}
		}

		return jp.readValueAs(targetClass);
	}
}