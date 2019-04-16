package es.redmic.test.unit.geodata.geofixedtimeseries.dto;

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

import es.redmic.models.es.series.common.dto.MeasurementDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class MeasurementsDTOTest extends DTOBaseTest<MeasurementDTO> {
	
	private static MeasurementDTO dto = new MeasurementDTO();

	@Before
	public void reset() {

		dto = new MeasurementDTO();
		dto.setDataDefinition(CompleteDTOUtils.completeDataDefinitionSeries());
		dto.setParameter(CompleteDTOUtils.completeHierarchicalParameter());
		dto.setUnit(CompleteDTOUtils.completeUnitDTO());
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfDataDefinitionIsNull() {

		dto.setDataDefinition(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfParameterIsNull() {

		dto.setParameter(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfUnitIsNull() {

		dto.setUnit(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}
