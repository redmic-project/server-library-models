package es.redmic.test.unit.common.constraintvalidate;

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

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.redmic.models.es.common.query.dto.BboxQueryDTO;

public class BboxValidateTest {

	ObjectMapper mapper = new ObjectMapper();

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	public void validateBboxQuery_ReturnTrue_IfFulfillConstraints()
			throws JsonParseException, JsonMappingException, IOException {

		String bboxString = "{\"bottomRightLat\": 80, \"bottomRightLon\": -170, \"topLeftLat\": 90, \"topLeftLon\": -180}";

		BboxQueryDTO bbox = mapper.readValue(bboxString, BboxQueryDTO.class);

		Set<ConstraintViolation<BboxQueryDTO>> constraintViolations = validator.validate(bbox);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void validateBboxQuery_ReturnFalse_IfCoordinateIsNull()
			throws IOException, JsonParseException, JsonProcessingException {

		String bboxString = "{\"bottomRightLat\": null, \"bottomRightLon\": -13, \"topLeftLat\": 30, \"topLeftLon\": -18}";

		BboxQueryDTO bbox = mapper.readValue(bboxString, BboxQueryDTO.class);

		Set<ConstraintViolation<BboxQueryDTO>> constraintViolations = validator.validate(bbox);
		assertEquals(2, constraintViolations.size());
	}

	@Test
	public void validateBboxQuery_ReturnFalse_IfBottomRightLatGreaterThanTopLeftLat()
			throws IOException, JsonParseException, JsonProcessingException {

		String bboxString = "{\"bottomRightLat\": 36, \"bottomRightLon\": -13, \"topLeftLat\": 30, \"topLeftLon\": -18}";

		BboxQueryDTO bbox = mapper.readValue(bboxString, BboxQueryDTO.class);

		Set<ConstraintViolation<BboxQueryDTO>> constraintViolations = validator.validate(bbox);
		assertEquals(1, constraintViolations.size());
	}

	@Test
	public void validateBboxQuery_ReturnFalse_IfCoordinateGreaterThanLimit()
			throws IOException, JsonParseException, JsonProcessingException {

		String bboxString = "{\"bottomRightLat\": 26, \"bottomRightLon\": -13, \"topLeftLat\": 190, \"topLeftLon\": -18}";

		BboxQueryDTO bbox = mapper.readValue(bboxString, BboxQueryDTO.class);

		Set<ConstraintViolation<BboxQueryDTO>> constraintViolations = validator.validate(bbox);
		assertEquals(1, constraintViolations.size());
	}
}
