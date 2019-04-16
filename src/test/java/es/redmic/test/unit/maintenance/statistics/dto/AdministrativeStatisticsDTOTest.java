package es.redmic.test.unit.maintenance.statistics.dto;

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
