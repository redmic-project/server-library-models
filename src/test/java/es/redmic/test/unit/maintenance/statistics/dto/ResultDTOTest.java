package es.redmic.test.unit.maintenance.statistics.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.statistics.dto.ResultDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ResultDTOTest extends DTOBaseTest<ResultDTO> {
	
	private static ResultDTO dto = new ResultDTO();

	@Before
	public void reset() {

		dto = new ResultDTO();
	}

	@Test
	public void validDto() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void openNotValid() {

		dto.setOpen(-1);

		checkDTOHasError(dto, MIN_MESSAGE_TEMPLATE);
	}

	@Test
	public void closeNotValid() {

		dto.setClose(-1);

		checkDTOHasError(dto, MIN_MESSAGE_TEMPLATE);
	}

	@Test
	public void openValid() {

		dto.setOpen(1);

		checkDTOHasNoError(dto);
	}

	@Test
	public void closeValid() {

		dto.setClose(1);

		checkDTOHasNoError(dto);
	}
}