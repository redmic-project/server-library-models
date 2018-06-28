package es.redmic.test.unit.administrative.taxonomy.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.taxonomy.dto.WormsClassificationDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;
import es.redmic.test.utils.json.JsonToBeanTestUtil;

public class WormsClassificationDTOTest extends DTOBaseTest<WormsClassificationDTO> {

	private static WormsClassificationDTO dto = new WormsClassificationDTO();

	@Before
	public void reset() throws IOException {

		dto = (WormsClassificationDTO) JsonToBeanTestUtil.getBean("/worms/classification.json",
				WormsClassificationDTO.class);
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfScientificnameIsNull() {

		dto.setScientificname(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfScientificnameExceedsSize() {

		dto.setScientificname(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfRankExceedsSize() {

		dto.setRank(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void loadWormsClassification_ReturnWormsClassificationDTO_IfFormatIsCorrect() throws IOException {

		WormsClassificationDTO result = (WormsClassificationDTO) JsonToBeanTestUtil
				.getBean("/worms/classification.json", WormsClassificationDTO.class);

		assertEquals(result.getAphia().intValue(), 1);
		assertEquals(result.getScientificname(), "Biota");
		assertEquals(result.getRank(), "Superdomain");

		assertEquals(result.getChild().getRank(), "Kingdom");

		WormsClassificationDTO child = result.getChild();
		int cont = 0;
		while (child != null) {
			cont++;
			child = child.getChild();
		}
		assertEquals(cont, 14);
	}

	@Test
	public void getByRank_ReturnWormsClassificationDTO_IfRankExistInClassification() {

		List<String> rankList = Arrays.asList("Kingdom", "Phylum", "Subphylum", "Class", "Order", "Family", "Genus");

		for (String rank : rankList) {

			WormsClassificationDTO taxon = dto.getItemByRank(rank);
			assertNotNull(taxon);
			assertEquals(taxon.getRank(), rank);
		}
	}

	@Test
	public void getParentItemByAphia_ReturnWormsClassificationDTO_IfAphiaExistInClassification() {

		WormsClassificationDTO taxon = dto.getParentItemByAphia(136470);
		assertNotNull(taxon);
		assertEquals(taxon.getAphia().intValue(), 136235);
		assertEquals(taxon.getRank(), "Genus");
	}

	@Test
	public void getParentItemByAphia_ReturnNull_IfAphiaNotExistInClassification() {

		WormsClassificationDTO taxon = dto.getParentItemByAphia(13647034);
		assertNull(taxon);
	}
}