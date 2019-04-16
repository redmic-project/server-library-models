package es.redmic.test.utils.json;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonToBeanTestUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(JsonToBeanTestUtil.class);

	private static ObjectMapper jacksonMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

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

		String json = null;

		try {
			json = new String(Files.readAllBytes(new ClassPathResource(filePath).getFile().toPath()));

		} catch (IOException e) {
			LOGGER.error("No existe el recurso " + filePath);
			e.printStackTrace();
		}

		return json;
	}
}
