package es.redmic.test.unit.administrative.taxonomy.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.taxonomy.dto.AnimalDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class AnimalDTOTest extends DTOBaseTest<AnimalDTO> {

	private static AnimalDTO dto = new AnimalDTO();

	@Before
	public void reset() {

		dto = (AnimalDTO) CompleteDTOUtils.completeAnimalDTO();
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfPhotoExceedsSize() {

		dto.setPhoto(generateString(250));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfTaxonIsNull() {

		dto.setTaxon(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {
		
		dto.setNote(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfReleaseLocalityExceedsSize() {

		dto.setReleaseLocality(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}