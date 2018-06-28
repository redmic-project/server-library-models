package es.redmic.test.unit.common.constraintvalidate;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.redmic.models.es.common.query.dto.DateLimitsDTO;

public class DateRangeValidateTest {

	ObjectMapper mapper = new ObjectMapper();

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Test
	public void validateDateLimitsQuery_ReturnTrue_IfFulfillConstraints()
			throws IOException, JsonParseException, JsonProcessingException {

		String dateLimitsString = "{\"startDate\": \"1970-01-01T00:00:00.001+00:00\", \"endDate\": \"1971-01-01T00:00:00.001+00:00\"}";

		DateLimitsDTO dateLimits = mapper.readValue(dateLimitsString, DateLimitsDTO.class);

		Set<ConstraintViolation<DateLimitsDTO>> constraintViolations = validator.validate(dateLimits);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void deserializeDateLimitsQuery_ReturnFalse_IfStartDateGreaterThan()
			throws IOException, JsonParseException, JsonProcessingException {

		String dateLimitsString = "{\"startDate\": \"1972-01-01T00:00:00.001+00:00\", \"endDate\": \"1971-01-01T00:00:00.001+00:00\"}";

		DateLimitsDTO dateLimits = mapper.readValue(dateLimitsString, DateLimitsDTO.class);

		Set<ConstraintViolation<DateLimitsDTO>> constraintViolations = validator.validate(dateLimits);
		assertEquals(1, constraintViolations.size());
	}
}
