package es.redmic.test.unit.common.constraintvalidate;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.DocumentDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;

public class LanguageValidateTest {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private static DocumentDTO dto = new DocumentDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeDocumentDTO();
	}

	@Test
	public void validateLanguage_ReturnTrue_IfLanguageIsSupported() {

		dto.setLanguage("es");
		
		Set<ConstraintViolation<DocumentDTO>> constraintViolations = validator.validate(dto);
		assertEquals(0, constraintViolations.size());
	}
	
	@Test
	public void validateLanguage_ReturnFalse_IfLanguageIsNotSupported() {

		dto.setLanguage("ru");
		
		Set<ConstraintViolation<DocumentDTO>> constraintViolations = validator.validate(dto);
		assertEquals(1, constraintViolations.size());
		assertEquals("{redmic.validation.constraints.ValidateLanguage.message}", constraintViolations.iterator().next().getMessageTemplate());
	}
}
