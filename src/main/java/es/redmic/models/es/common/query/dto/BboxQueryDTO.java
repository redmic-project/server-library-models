package es.redmic.models.es.common.query.dto;

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

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.constraintvalidate.bbox.ValidateBbox;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@ValidateBbox(bottomRightLat="bottomRightLat", bottomRightLon="bottomRightLon", topLeftLat="topLeftLat", topLeftLon="topLeftLon")
public class BboxQueryDTO {

	@NotNull
	@Min(-90)
	@Max(90)
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	Double bottomRightLat;
	@NotNull
	@Min(-180)
	@Max(180)
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	Double bottomRightLon;

	@NotNull
	@Min(-90)
	@Max(90)
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	Double topLeftLat;
	@NotNull
	@Min(-180)
	@Max(180)
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	Double topLeftLon;

	public BboxQueryDTO() {
	}

	public Double getBottomRightLat() {
		return bottomRightLat;
	}

	public void setBottomRightLat(Double bottomRightLat) {
		this.bottomRightLat = bottomRightLat;
	}

	public Double getBottomRightLon() {
		return bottomRightLon;
	}

	public void setBottomRightLon(Double bottomRightLon) {
		this.bottomRightLon = bottomRightLon;
	}

	public Double getTopLeftLat() {
		return topLeftLat;
	}

	public void setTopLeftLat(Double topLeftLat) {
		this.topLeftLat = topLeftLat;
	}

	public Double getTopLeftLon() {
		return topLeftLon;
	}

	public void setTopLeftLon(Double topLeftLon) {
		this.topLeftLon = topLeftLon;
	}
}
