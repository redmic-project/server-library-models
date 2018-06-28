package es.redmic.test.unit.administrative.taxonomy.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.taxonomy.dto.KingdomDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class KingdomDTOTest extends DTOBaseTest<KingdomDTO> {

	private static KingdomDTO dto = new KingdomDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeKingdomDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
}