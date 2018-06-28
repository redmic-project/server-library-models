package es.redmic.test.unit.geodata.common.model;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Point;

import es.redmic.models.es.geojson.common.model.GeoHitWrapper;
import es.redmic.models.es.geojson.common.model.GeoSearchWrapper;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;
import es.redmic.models.es.series.timeseries.model.TimeSeries;

@RunWith(MockitoJUnitRunner.class)
public class GeoSearchWrapperMapperTest {

	private String dataFile = "/geodata/model/ResponseDataES.json";
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
	public void deserializeAndSerializeModel()
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		mapper.registerModule(jTSModule);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		TypeReference<GeoSearchWrapper<GeoDataProperties, Point>> typeRef = 
				new TypeReference<GeoSearchWrapper<GeoDataProperties, Point>>() {};

		GeoSearchWrapper<GeoDataProperties, Point> model = mapper
				.readValue(getClass().getResource(dataFile).openStream(), typeRef);
		
		
		List<GeoHitWrapper<GeoDataProperties, Point>> hits = model.getHits().getHits();
	
		assertTrue(model.getTotal() == 41033);
		assertTrue(hits.size() == 1);
		
		List<TimeSeries> inner_hits = hits.get(0).getInner_hits().getTimeseries().getSourceList();
		
		assertTrue(inner_hits.size() == 1);
		
	}
}
