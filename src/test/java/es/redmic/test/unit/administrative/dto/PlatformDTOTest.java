package es.redmic.test.unit.administrative.dto;

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

import es.redmic.models.es.administrative.dto.PlatformDTO;
import es.redmic.models.es.maintenance.administrative.dto.PlatformTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class PlatformDTOTest extends DTOBaseTest<PlatformDTO> {

	private static PlatformDTO dto = new PlatformDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completePlatformDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfNameIsNull() {

		dto.setName(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameHasInsufficientLength() {

		dto.setName("");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setLicence(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setLicence(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfLicenceExceedsSize() {

		dto.setLicence(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfContactPhoneExceedsSize() {

		dto.setContactPhone("45345554433423445553");

		checkDTOHasError(dto, PHONE_NUMBER_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnFormatError_IfPhoneIsBadFormat() {

		dto.setContactPhone("66666666a");

		checkDTOHasError(dto, PHONE_NUMBER_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_NoReturnError_IfOrganisationIsCorrect() {

		dto.setOrganisation(CompleteDTOUtils.completeOrganisationDTO());

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_NoReturnError_IfPlatformTypeIsCorrect() {

		dto.setPlatformType(((PlatformTypeDTO) CompleteDTOUtils.completeObjectDomain(new PlatformTypeDTO())));

		checkDTOHasNoError(dto);
	}
}
