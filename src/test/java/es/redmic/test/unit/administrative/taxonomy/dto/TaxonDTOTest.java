package es.redmic.test.unit.administrative.taxonomy.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class TaxonDTOTest extends DTOBaseTest<TaxonDTO> {
	
	private static TaxonDTO dto = new TaxonDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeTaxonDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfScientificNameIsNull() {

		dto.setScientificName(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfScientificNameExceedsSize() {


		dto.setScientificName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfAuthorshipExceedsSize() {

		dto.setAuthorship(generateString(200));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCommonNameExceedsSize() {

		dto.setCommonName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfWormsExceedsSize() {

		dto.setWorms(generateString(250));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setNote(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfParentIsNull() {

		dto.setParent(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}