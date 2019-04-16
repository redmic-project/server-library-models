package es.redmic.test.unit.common.dto;

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

import es.redmic.models.es.common.dto.DomainImplDTO;

@SuppressWarnings("unchecked")
public abstract class DomainBaseDTOTest<TDTO extends DomainImplDTO> extends DTOBaseTest<TDTO> {
	
	protected static DomainImplDTO dto = new DomainImplDTO();
	
	@Before
	public void beforeTest() {

		dto.setName("name");
		dto.setName_en("name_en");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError((TDTO) dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfNameIsNull() {

		dto.setName(null);

		checkDTOHasError((TDTO) dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(150));

		checkDTOHasError((TDTO) dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfName_enIsNull() {

		dto.setName_en(null);

		checkDTOHasError((TDTO) dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfName_enExceedsSize() {

		dto.setName_en(generateString(150));

		checkDTOHasError((TDTO) dto, SIZE_MESSAGE_TEMPLATE);
	}
}
