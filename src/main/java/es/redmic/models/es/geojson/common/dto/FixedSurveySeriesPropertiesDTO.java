package es.redmic.models.es.geojson.common.dto;

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
