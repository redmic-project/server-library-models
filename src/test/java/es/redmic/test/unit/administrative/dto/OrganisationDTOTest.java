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

import es.redmic.models.es.administrative.dto.OrganisationDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class OrganisationDTOTest extends DTOBaseTest<OrganisationDTO> {

	private static OrganisationDTO dto = new OrganisationDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeOrganisationDTO();
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
	public void validationDTO_ReturnFormatError_IfWebpageIsBadFormat() {

		dto.setWebpage("htttp//:ff.cc");

		checkDTOHasError(dto, URL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfUrlExceedsSize() {

		dto.setWebpage("http://" + generateString(300) + ".com");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameHasInsufficientLength() {

		dto.setName("");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setNote(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfAddressExceedsSize() {

		dto.setAddress(generateString(500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfEmailExceedsSize() {

		String aux = generateString(50);

		dto.setEmail(aux + "@hotmail.com");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnFormatError_IfEmailIsBadFormat() {

		dto.setEmail("aaa");

		checkDTOHasError(dto, EMAIL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_NoReturnError_IfPhoneIsCorrect() {

		dto.setPhone("676334455");

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnFormatError_IfPhoneIsBadFormat() {

		dto.setPhone("+676334455");

		checkDTOHasError(dto, PHONE_NUMBER_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfLogoExceedsSize() {

		dto.setLogo(generateString(250));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfOrganisationTypeIsNull() {

		dto.setOrganisationType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}
