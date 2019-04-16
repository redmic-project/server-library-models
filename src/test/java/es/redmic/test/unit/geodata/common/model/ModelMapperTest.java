package es.redmic.test.unit.geodata.common.model;

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
import java.nio.file.Files;

import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.redmic.jts4jackson.module.JTSModule;
import es.redmic.models.es.geojson.common.model.GeoPointData;

public class ModelMapperTest {

	private String dataFile = "/geodata/model/allData.json";

	ObjectMapper mapper = new ObjectMapper();

	@BeforeClass
	public static void setUp() {
	}

	@Before
	public void reset() {

	}

	@Test
	public void deserializeAndSerializeModel()
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		mapper.registerModule(new JTSModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		GeoPointData model = mapper.readValue(getClass().getResource(dataFile).openStream(), GeoPointData.class);

		String source = new String(Files.readAllBytes(new ClassPathResource(dataFile).getFile().toPath()));
		String expected = mapper.writeValueAsString(model);

		JSONAssert.assertEquals(expected, source, false);
	}
}
