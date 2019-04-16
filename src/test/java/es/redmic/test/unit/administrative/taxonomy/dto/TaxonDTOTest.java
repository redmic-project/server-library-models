package es.redmic.test.unit.administrative.taxonomy.dto;

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

import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class TaxonDTOTest extends DTOBaseTest<TaxonDTO> {
	
	private static TaxonDTO dto = new TaxonDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeTaxonDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfScientificNameIsNull() {

		dto.setScientificName(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfScientificNameExceedsSize() {


		dto.setScientificName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfAuthorshipExceedsSize() {

		dto.setAuthorship(generateString(200));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCommonNameExceedsSize() {

		dto.setCommonName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfWormsExceedsSize() {

		dto.setWorms(generateString(250));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setNote(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfParentIsNull() {

		dto.setParent(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}
