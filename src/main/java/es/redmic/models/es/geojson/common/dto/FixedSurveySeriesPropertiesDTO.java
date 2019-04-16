package es.redmic.models.es.geojson.common.dto;

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

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.maintenance.survey.dto.FixedSurveyDTO;
import es.redmic.models.es.series.common.dto.MeasurementDTO;

@JsonSchemaNotNull
public class FixedSurveySeriesPropertiesDTO extends PropertiesDTO {

	@NotNull
	@Valid
	private FixedSurveyDTO site;

	@NotNull
	@Size(min = 1)
	@Valid
	private List<MeasurementDTO> measurements;

	public FixedSurveyDTO getSite() {
		return site;
	}

	public void setSite(FixedSurveyDTO site) {
		this.site = site;
	}

	public List<MeasurementDTO> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<MeasurementDTO> measurements) {
		this.measurements = measurements;
	}
}
