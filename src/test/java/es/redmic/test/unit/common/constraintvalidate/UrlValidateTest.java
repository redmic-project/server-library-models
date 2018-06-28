package es.redmic.test.unit.common.constraintvalidate;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.OrganisationDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;

public class UrlValidateTest {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private static OrganisationDTO dto = new OrganisationDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeOrganisationDTO();
	}

	@Test
	public void validateUrl_ReturnTrue_IfFulfillConstraints() {

		dto.setWebpage("http://redmic.es");
		
		Set<ConstraintViolation<OrganisationDTO>> constraintViolations = validator.validate(dto);
		assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void validateUrl_ReturnTrue_IfContainWWW() {

		dto.setWebpage("http://www.redmic.es");
		
		Set<ConstraintViolation<OrganisationDTO>> constraintViolations = validator.validate(dto);
		assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void validateUrl_ReturnTrue_IfContainHttps() {

		dto.setWebpage("https://www.redmic.es");
		
		Set<ConstraintViolation<OrganisationDTO>> constraintViolations = validator.validate(dto);
		assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void validateUrl_ReturnFormatError_IfWebpageIsBadFormat() {

		dto.setWebpage("htttp//:ff.cc");

		Set<ConstraintViolation<OrganisationDTO>> constraintViolations = validator.validate(dto);
		assertEquals(1, constraintViolations.size());
		assertEquals("{redmic.validation.constraints.ValidateUrl.message}", constraintViolations.iterator().next().getMessageTemplate());
	}
	
	@Test
	public void validateUrl_ReturnFormatError_IfNoContainHttp() {

		dto.setWebpage("redmic.es");

		Set<ConstraintViolation<OrganisationDTO>> constraintViolations = validator.validate(dto);
		assertEquals(1, constraintViolations.size());
		assertEquals("{redmic.validation.constraints.ValidateUrl.message}", constraintViolations.iterator().next().getMessageTemplate());
	}
}
