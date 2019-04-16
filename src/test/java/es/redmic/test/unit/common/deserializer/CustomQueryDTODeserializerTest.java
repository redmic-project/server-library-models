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
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import es.redmic.models.es.common.query.dto.DataQueryDTO;
import es.redmic.models.es.common.query.dto.GeoDataQueryDTO;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO;
import es.redmic.models.es.common.view.QueryDTODeserializerModifier;

public class CustomQueryDTODeserializerTest {

	ObjectMapper mapper = new ObjectMapper();

	@Before
	public void before() {
		
		SimpleModule module = new SimpleModule();
		module.setDeserializerModifier(new QueryDTODeserializerModifier());
		mapper.registerModule(module);

		// Simula el módulo que setea la vista según el role
		mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		mapper.setConfig(mapper.getDeserializationConfig().withView(JsonViewsForQueryDTO.Guest.class));

		
		FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false).addFilter("DataQueryDTO",
				SimpleBeanPropertyFilter.serializeAll());
		mapper.setFilterProvider(filters);
	}

	@Test(expected = UnrecognizedPropertyException.class)
	public void deserialize_ThrowException_WhenReceiveNotAllowedProperty() throws IOException {

		String queryDTOString = "{\"from\":1, \"accessibilityIds\": [2]}";

		mapper.readValue(queryDTOString, DataQueryDTO.class);
	}
	
	@Test(expected = UnrecognizedPropertyException.class)
	public void deserialize_ThrowException_WhenReceiveUnknownProperty() throws IOException {

		String queryDTOString = "{\"from\":1, \"unknownProperty\": 2}";

		mapper.readValue(queryDTOString, DataQueryDTO.class);
	}

	@Test
	public void deserialize_ReturnEmptyClass_WhenReceiveEmptyObject() throws IOException {

		String queryDTOString = "{}";

		DataQueryDTO query = mapper.readValue(queryDTOString, DataQueryDTO.class);

		assertEquals(mapper.writeValueAsString(query), mapper.writeValueAsString(new DataQueryDTO()));
	}

	@Test
	public void deserialize_ReturnClass_WhenReceiveCorrectObject() throws IOException {

		mapper.setConfig(mapper.getDeserializationConfig().withView(JsonViewsForQueryDTO.Administrator.class));

		String queryDTOString = "{\"from\":2, \"accessibilityIds\": [3]}";

		DataQueryDTO query = mapper.readValue(queryDTOString, DataQueryDTO.class);

		assertTrue(query.getAccessibilityIds().get(0).equals(3L));
	}

	@Test
	public void deserialize_ReturnClass_WhenReceiveClass() throws IOException {
		
		mapper.setConfig(mapper.getDeserializationConfig().withView(JsonViewsForQueryDTO.Guest.class));
		String queryDTOString = "{\"bbox\": {\"bottomRightLat\": 26.5484619140625,\"bottomRightLon\": -12.711181640625,\"topLeftLat\": 30.4486083984375,\"topLeftLon\": -19.2974853515625}}";

		DataQueryDTO query = mapper.readValue(queryDTOString, DataQueryDTO.class);

		assertTrue(query.getBbox() != null);
		assertTrue(query.getBbox().getBottomRightLat() != null);
	}
	
	@Test
	public void deserialize_ReturnClass_WhenReceiveSubClass() throws IOException {
		
		mapper.setConfig(mapper.getDeserializationConfig().withView(JsonViewsForQueryDTO.Guest.class));
		String queryDTOString = "{\"bbox\": {\"bottomRightLat\": 26.5484619140625,\"bottomRightLon\": -12.711181640625,\"topLeftLat\": 30.4486083984375,\"topLeftLon\": -19.2974853515625}}";

		GeoDataQueryDTO query = mapper.readValue(queryDTOString, GeoDataQueryDTO.class);

		assertTrue(query.getBbox() != null);
		assertTrue(query.getBbox().getBottomRightLat() != null);
	}
	
	/*@Test(expected=UnrecognizedPropertyException.class)
	public void deserialize_ThrowException_WhenReceiveIgnorePropertyByFilter() throws IOException {
		
		String queryDTOString = "{\"qFlags\": [2]}";

		mapper.readValue(queryDTOString, DataQueryDTO.class);
	}*/

}
