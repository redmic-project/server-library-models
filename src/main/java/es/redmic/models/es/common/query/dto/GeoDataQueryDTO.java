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

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDescription;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonSchemaNotNull
public class GeoDataQueryDTO extends DataAccessibilityQueryDTO {

	public GeoDataQueryDTO() {
		super();
	}

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@JsonSchemaDescription("Obtiene registros de geometrías comprendidas dentro de los límites especificados.")
	@Valid
	private BboxQueryDTO bbox;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private PrecisionQueryDTO precision;

	public BboxQueryDTO getBbox() {
		return bbox;
	}

	public void setBbox(BboxQueryDTO bbox) {
		this.bbox = bbox;
	}

	public PrecisionQueryDTO getPrecision() {
		return precision;
	}

	public void setPrecision(PrecisionQueryDTO precision) {
		this.precision = precision;
	}
}
