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
