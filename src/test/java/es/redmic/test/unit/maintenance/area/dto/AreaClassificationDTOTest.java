package es.redmic.test.unit.maintenance.area.dto;

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

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.areas.dto.AreaClassificationDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class AreaClassificationDTOTest extends DTOBaseTest<AreaClassificationDTO> {

	private static AreaClassificationDTO dto = new AreaClassificationDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeAreaClassificationDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	// @Test
	public void validationDTO_ReturnNotNullError_IfActivityIsNull() {

		dto.setType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnValidateDateRangeError_IfEndDateGreatThanStartDate() {

		dto.setEndDate(new DateTime("2014-03-17T00:00:00.000Z"));

		checkDTOHasError(dto, DATE_RANGE_MESSAGE_TEMPLATE);
	}

	@SuppressWarnings("serial")
	@Test
	public void validationDTO_ReturnValidateDateRangeError_IfStartDateIsNullAndEndDateIsNotNull() {

		dto.setEndDate(new DateTime("2014-03-17T00:00:00.000Z"));
		dto.setStartDate(null);

		checkDTOHasError(dto, new ArrayList<String>() {
			{
				add(DATE_RANGE_MESSAGE_TEMPLATE);
			}
		});
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}
