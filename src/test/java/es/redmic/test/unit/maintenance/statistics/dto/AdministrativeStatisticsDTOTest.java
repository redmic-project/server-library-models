package es.redmic.test.unit.maintenance.statistics.dto;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.redmic.models.es.maintenance.statistics.dto.AdministrativeStatisticsDTO;

public class AdministrativeStatisticsDTOTest {
	private static Validator validator;

	private static AdministrativeStatisticsDTO dto = new AdministrativeStatisticsDTO();

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void reset() {

		dto = new AdministrativeStatisticsDTO();
	}

	@Test
	public void validDto() {

		Set<ConstraintViolation<AdministrativeStatisticsDTO>> constraintViolations = validator.validate(dto);
		assertEquals(0, constraintViolations.size());
	}

}