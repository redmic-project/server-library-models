package es.redmic.test.unit.geodata.tracking.animal.dto;

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