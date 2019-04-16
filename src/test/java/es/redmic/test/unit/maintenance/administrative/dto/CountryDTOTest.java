package es.redmic.test.unit.maintenance.administrative.dto;

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

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.administrative.dto.CountryDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class CountryDTOTest extends DTOBaseTest<CountryDTO> {
	
	private static CountryDTO dto = new CountryDTO();

	@Before
	public void reset() {

		dto.setName("name");
		dto.setName_en("name_en");
		dto.setCode("co");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfCodeIsNull() {

		dto.setCode(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCodeExceedsSize() {

		dto.setCode(generateString(3));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}
