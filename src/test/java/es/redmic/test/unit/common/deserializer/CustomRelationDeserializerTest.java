package es.redmic.test.unit.common.deserializer;

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

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.models.es.maintenance.parameter.dto.UnitTypeDTO;

public class CustomRelationDeserializerTest {

	@Mock
	private JsonParser jp;
	
	ObjectMapper mapper = new ObjectMapper();
	static UnitDTO unit;
	static UnitDTO unitFromId;


	@BeforeClass
	public static void setUp() {
		unit = new UnitDTO();
		unit.setId(1L);
		unit.setName("unit");
		
		UnitTypeDTO unitType = new UnitTypeDTO();
		unitType.setId(1L);
		
		unit.setUnitType(unitType);
		
		unitFromId = new UnitDTO();
		unitFromId.setId(1L);
		unitFromId.setUnitType(unitType);

	}

	@Test
	public void testDeserializeById() throws ParseException, JsonParseException, JsonProcessingException, IOException {
		UnitDTO item = deserialize(1L);
		assertEquals(item.getId(), unitFromId.getId());
	}
	
	@Test
	public void testDeserializeByObject() throws ParseException, JsonParseException, JsonProcessingException, IOException {
		UnitDTO item = deserialize(unit);
		assertEquals(item.getId(), unitFromId.getId());
		assertEquals(item.getUnitType().getId(), unitFromId.getUnitType().getId());
	}

	private UnitDTO deserialize(Long id) throws IOException, JsonParseException, JsonProcessingException {
		TestObject testObject = mapper.readValue("{\"unit\":" + id + "}", TestObject.class);

		return testObject.getUnit();
	}
	
	private UnitDTO deserialize(UnitDTO item) throws IOException, JsonParseException, JsonProcessingException {
		
		TestObject testObject = mapper.readValue("{\"unit\":" +mapper.writeValueAsString(item) + "}", TestObject.class);

		return testObject.getUnit();
	}

	private static class TestObject {

		@JsonDeserialize(using = CustomRelationDeserializer.class)
		private final UnitDTO unit = null;

		public UnitDTO getUnit() {
			return unit;
		}
	}
}
