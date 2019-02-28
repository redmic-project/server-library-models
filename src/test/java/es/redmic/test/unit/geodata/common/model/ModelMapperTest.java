package es.redmic.test.unit.geodata.common.model;

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
