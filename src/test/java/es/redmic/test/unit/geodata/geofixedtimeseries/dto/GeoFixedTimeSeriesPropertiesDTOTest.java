package es.redmic.test.unit.geodata.geofixedtimeseries.dto;

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
