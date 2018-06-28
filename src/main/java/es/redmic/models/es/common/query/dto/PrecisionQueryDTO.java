package es.redmic.models.es.common.query.dto;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.constraintvalidate.range.ValidateRange;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@ValidateRange(min="min", max="max")
public class PrecisionQueryDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private Double min;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private Double max;

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}
}
