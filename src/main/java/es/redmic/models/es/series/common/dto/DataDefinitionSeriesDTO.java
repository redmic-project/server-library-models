package es.redmic.models.es.series.common.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;

import es.redmic.models.es.maintenance.parameter.dto.DataDefinitionDTO;

public class DataDefinitionSeriesDTO extends DataDefinitionDTO {

	@NotNull
	public Double getZ() {
		return z;
	}
	
	@Min(value = 1)
	@NotNull
	public Long getTimeInterval() {
		return timeInterval;
	}

	@NotNull
	@JsonSchemaDefault(value = "true")
	public Boolean getIsSerial() {
		return isSerial;
	}
}
