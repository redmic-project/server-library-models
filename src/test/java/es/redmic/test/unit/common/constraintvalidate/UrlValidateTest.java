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
