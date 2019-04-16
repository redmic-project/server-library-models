package es.redmic.models.es.common.deserializer;

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
