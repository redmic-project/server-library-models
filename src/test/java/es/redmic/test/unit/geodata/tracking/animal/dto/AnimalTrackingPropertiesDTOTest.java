package es.redmic.test.unit.geodata.tracking.animal.dto;

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

import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingPropertiesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class AnimalTrackingPropertiesDTOTest extends DTOBaseTest<AnimalTrackingPropertiesDTO> {

	private static AnimalTrackingPropertiesDTO dto = new AnimalTrackingPropertiesDTO();

	@Before
	public void reset() {

		dto = new AnimalTrackingPropertiesDTO();
		dto.setActivityId("r.1.2.3");
		dto.setAnimal(CompleteDTOUtils.completeAnimalDTO());
		dto.setDevice(CompleteDTOUtils.completeDeviceDTO());
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	// @Test
	public void validationDTO_ReturnNotNullError_IfActivityIsNull() {

		dto.setActivityId(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfAnimalIsNull() {

		dto.setAnimal(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfDeviceIsNull() {

		dto.setDevice(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}
