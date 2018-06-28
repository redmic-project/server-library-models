package es.redmic.test.unit.series.timeseries.dto;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.series.timeseries.dto.TimeSeriesDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class TimeSeriesDTOTest extends DTOBaseTest<TimeSeriesDTO> {

	private static TimeSeriesDTO dto = new TimeSeriesDTO();

	@Before
	public void reset() {
		
		dto.setValue(1.0);
		dto.setDate(new DateTime());
		dto.setRemark("remark");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfValueIsNull() {

		dto.setValue(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfDateIsNull() {

		dto.setDate(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}