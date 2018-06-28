package es.redmic.test.unit.administrative.taxonomy.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.taxonomy.dto.SpeciesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class SpeciesDTOTest extends DTOBaseTest<SpeciesDTO> {
	
	private static SpeciesDTO dto = new SpeciesDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeSpeciesDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfImageExceedsSize() {

		dto.setImage(generateString(250));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfGroupIconExceedsSize() {

		dto.setGroupIcon(generateString(250));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}