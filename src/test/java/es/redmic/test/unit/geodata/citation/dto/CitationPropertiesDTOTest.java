package es.redmic.test.unit.geodata.citation.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.geojson.citation.dto.CitationPropertiesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class CitationPropertiesDTOTest extends DTOBaseTest<CitationPropertiesDTO> {

	private static CitationPropertiesDTO dto = new CitationPropertiesDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeCitationPropertiesDTO();
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
	public void validationDTO_ReturnNotNullError_IfRadiusIsNull() {

		dto.setRadius(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCollectorNameExceedsSize() {

		dto.setCollectorName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfSpeciesConfidenceIsNull() {

		dto.setSpeciesConfidence(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfTaxonIsNull() {

		dto.setTaxon(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}