package es.redmic.models.es.common.query.dto;

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