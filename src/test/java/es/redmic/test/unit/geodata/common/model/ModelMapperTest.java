package es.redmic.test.unit.geodata.common.model;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.redmic.models.es.geojson.common.model.GeoPointData;

@RunWith(MockitoJUnitRunner.class)
public class ModelMapperTest {

	private String dataFile = "/geodata/model/allData.json";
	private Module jTSModule = new JtsModule();
	
	@InjectMocks
	ObjectMapper mapper;

	@BeforeClass
	public static void setUp() {
	}

	@Before
	public void reset() {

	}

	@Test
	public void deserializeAndSerializeModel() throws JsonParseException, JsonMappingException, IOException, JSONException {

		mapper.registerModule(jTSModule);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GeoPointData model = mapper.readValue(getClass().getResource(dataFile).openStream(),
				GeoPointData.class);

		String source = IOUtils.toString(getClass().getResource(dataFile).openStream()); 
		String expected = mapper.writeValueAsString(model);
		
		JSONAssert.assertEquals(expected, source, false);
	}
}
