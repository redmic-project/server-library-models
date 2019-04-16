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

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.geojson.common.dto.FixedSurveySeriesPropertiesDTO;
import es.redmic.models.es.series.common.dto.MeasurementDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class GeoFixedTimeSeriesPropertiesDTOTest extends DTOBaseTest<FixedSurveySeriesPropertiesDTO> {

	private static FixedSurveySeriesPropertiesDTO dto = new FixedSurveySeriesPropertiesDTO();

	@Before
	public void reset() {

		dto = new FixedSurveySeriesPropertiesDTO();
		dto.setActivityId("r.1.2.3");
		dto.setSite(CompleteDTOUtils.completeSurveyStation());
		dto.setMeasurements(CompleteDTOUtils.completeMeasurementList());
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
	public void validationDTO_ReturnNotNullError_IfSiteIsNull() {

		dto.setSite(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfMeasurementsIsNull() {

		dto.setMeasurements(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfMeasurementsHasInsufficientLength() {

		dto.setMeasurements(new ArrayList<MeasurementDTO>());

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDashboardExceedsSize() {

		dto.getSite().setDashboard("http://" + generateString(501) + ".com");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnFormatError_IfDashboardUrlIsBadFormat() {

		dto.getSite().setDashboard("htttp//:ff.cc");

		checkDTOHasError(dto, URL_MESSAGE_TEMPLATE);
	}
}
