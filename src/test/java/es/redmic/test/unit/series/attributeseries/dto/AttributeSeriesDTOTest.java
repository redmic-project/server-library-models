package es.redmic.test.unit.series.attributeseries.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.qualifiers.dto.AttributeTypeBaseDTO;
import es.redmic.models.es.series.attributeseries.dto.AttributeSeriesDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class AttributeSeriesDTOTest extends DTOBaseTest<AttributeSeriesDTO> {

	private static AttributeSeriesDTO dto = new AttributeSeriesDTO();

	@Before
	public void reset() {
		
		AttributeTypeBaseDTO attributeType = new AttributeTypeBaseDTO();
		attributeType.setId(1L);
		dto.setAttributeType(attributeType );
		dto.setRemark("remark");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfAttributeTypeIsNull() {

		dto.setAttributeType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}