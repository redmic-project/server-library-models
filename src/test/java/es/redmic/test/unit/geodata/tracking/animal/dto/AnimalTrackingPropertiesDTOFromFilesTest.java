package es.redmic.test.unit.geodata.tracking.animal.dto;

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

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.redmic.models.es.administrative.taxonomy.dto.TaxonCompactExtendedDTO;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingPropertiesDTO;

public class AnimalTrackingPropertiesDTOFromFilesTest {

	private ArrayList<String> dataFilePaths = new ArrayList<String>(
			Arrays.asList("/data/pointTrackingPropertiesWithTaxonAsId.json", "/data/pointTrackingPropertiesWithTaxonAsObject.json"));

	@Test
	public void validDtoWithTaxonAsLong() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AnimalTrackingPropertiesDTO pointTrackingPropertiesDTO = mapper.readValue(getClass().getResource(dataFilePaths.get(0)).openStream(),
				AnimalTrackingPropertiesDTO.class);

		TaxonCompactExtendedDTO taxonDTO = pointTrackingPropertiesDTO.getAnimal().getTaxon();
		assertNotNull(taxonDTO.getId());
	}

	@Test
	public void validDtoWithTaxonAsObject() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AnimalTrackingPropertiesDTO pointTrackingPropertiesDTO = mapper.readValue(getClass().getResource(dataFilePaths.get(1)).openStream(),
				AnimalTrackingPropertiesDTO.class);

		TaxonCompactExtendedDTO taxonDTO = pointTrackingPropertiesDTO.getAnimal().getTaxon();
		assertNotNull(taxonDTO.getId());
		assertNotNull(taxonDTO.getScientificName());
	}
}
