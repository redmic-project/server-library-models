package es.redmic.test.unit.maintenance.parameter.dto;

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

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.parameter.dto.ParameterDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ParameterDTOTest extends DTOBaseTest<ParameterDTO> {

	private static ParameterDTO dto = new ParameterDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeParameterDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfName_enExceedsSize() {

		dto.setName_en(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfAcronymExceedsSize() {

		dto.setAcronym(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void parameterTypeNull() {

		dto.setParameterType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfParameterUnitIsNull() {

		dto.setUnits(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfUnitsArrayHasInsufficientLength() {

		dto.setUnits(new ArrayList<>());

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}
