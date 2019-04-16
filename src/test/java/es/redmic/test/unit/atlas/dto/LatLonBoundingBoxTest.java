package es.redmic.test.unit.atlas.dto;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.atlas.LatLonBoundingBox;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class LatLonBoundingBoxTest extends DTOBaseTest<LatLonBoundingBox> {

	private static LatLonBoundingBox dto = new LatLonBoundingBox();

	@Before
	public void reset() {

		dto.setMaxX(2.0);
		dto.setMaxY(2.0);
		dto.setMinX(2.0);
		dto.setMinY(2.0);
	}

	@Test
	public void validation_NoReturnError_IfObjectIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validation_ReturnNotNullError_IfFieldIsNull() {

		dto.setMaxX(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void equal_ReturnFalse_IfObjectNotIsInstanceOfLatLonBoundingBox() {

		assertFalse(dto.equals(new Object()));
	}

	@Test
	public void equal_ReturnFalse_IfObjectIsDiferent() {

		LatLonBoundingBox obj = new LatLonBoundingBox();

		obj.setMaxX(3.0);
		obj.setMaxY(2.0);
		obj.setMinX(2.0);
		obj.setMinY(2.0);

		assertFalse(dto.equals(obj));
	}

	@Test
	public void equal_ReturnTrue_IfObjectIsEqual() {

		assertTrue(dto.equals(dto));
	}
}
