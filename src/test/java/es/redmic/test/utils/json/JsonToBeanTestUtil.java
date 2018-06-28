package es.redmic.test.utils.json;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonToBeanTestUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(JsonToBeanTestUtil.class);

	private static ObjectMapper jacksonMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).registerModule(new JtsModule());

	private JsonToBeanTestUtil() {

	}

	public static Object getBean(String filePath, Class<?> clazz) throws IOException {

		String json = getResource(filePath);

		return jacksonMapper.readValue(json, clazz);
	}

	public static <T> T getBean(String filePath, final TypeReference<T> type) throws IOException {

		String json = getResource(filePath);

		return jacksonMapper.readValue(json, type);
	}

	public static String getJsonString(String filePath) throws IOException {

		return getResource(filePath);
	}

	private static String getResource(String filePath) throws IOException {
		InputStream resource = null;

		try {
			resource = JsonToBeanTestUtil.class.getResource(filePath).openStream();

		} catch (IOException e) {
			LOGGER.error("No existe el recurso " + filePath);
			e.printStackTrace();
		}

		String json = IOUtils.toString(resource);
		resource.close();

		return json;

	}
}