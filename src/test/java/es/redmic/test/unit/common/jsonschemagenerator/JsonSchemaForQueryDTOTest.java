package es.redmic.test.unit.common.jsonschemagenerator;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kjetland.jackson.jsonSchema.JsonSchemaGenerator;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO.ViewClassInterface;
import es.redmic.models.es.utils.JacksonFieldUtils;

public class JsonSchemaForQueryDTOTest {

	ObjectMapper mapper = new ObjectMapper();

	@SuppressWarnings("unchecked")
	@Test
	public void getFilterSchema_ReturnSpecificProperties_WhenSetView() throws JsonProcessingException {

		String filterSchemaExpected = 
			"{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"title\":\"Query\",\"type\":\"object\",\"properties\":{\"from\":{\"type\":[\"integer\",\"null\"]}}}";

		Class<?> viewClass = (Class<?>) JsonViewsForQueryDTO.Guest.class;
		
		Set<String> fieldsNoIncludedInView = JacksonFieldUtils.getFieldNamesNoIncludedInView(Query.class, (Class<ViewClassInterface>) viewClass);
		
		FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false).addFilter("DataQueryDTO",
				SimpleBeanPropertyFilter.serializeAllExcept(fieldsNoIncludedInView));
		mapper.setFilterProvider(filters);
		
		JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(mapper);
		JsonNode jsonSchema = jsonSchemaGenerator.generateJsonSchema(Query.class);

		String filterSchema = mapper.writeValueAsString(jsonSchema);
		assertEquals(filterSchema, filterSchemaExpected);
	}

	@SuppressWarnings({ "serial", "unchecked" })
	@Test
	public void getFilterSchema_ReturnEmptySchema_WhenSetViewAndFilterProperties() throws JsonProcessingException {
		String filterSchemaExpected = "{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"title\":\"Query\",\"type\":\"object\",\"properties\":{}}";

		Class<?> viewClass = (Class<?>) JsonViewsForQueryDTO.Guest.class;
		
		Set<String> fieldsNoIncludedInView = JacksonFieldUtils.getFieldNamesNoIncludedInView(Query.class, (Class<ViewClassInterface>) viewClass);
		
		Set<String> ignorableFieldNames = new HashSet<String>() {{ add("from"); }};

		ignorableFieldNames.addAll(fieldsNoIncludedInView);
		
		FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false).addFilter("DataQueryDTO",
				SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));
		mapper.setFilterProvider(filters);

		JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGenerator(mapper);
		JsonNode jsonSchema = jsonSchemaGenerator.generateJsonSchema(Query.class);

		String filterSchema = mapper.writeValueAsString(jsonSchema);
		assertEquals(filterSchema, filterSchemaExpected);
	}
}