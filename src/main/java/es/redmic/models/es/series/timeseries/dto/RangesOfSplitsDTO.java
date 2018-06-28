package es.redmic.models.es.series.timeseries.dto;

import java.util.ArrayList;
import java.util.List;

import es.redmic.models.es.common.dto.LimitsDTO;

public class RangesOfSplitsDTO {

	private List<LimitsDTO> limits = new ArrayList<LimitsDTO>();

	public List<LimitsDTO> getLimits() {
		return limits;
	}

	public void setLimits(List<LimitsDTO> limits) {
		this.limits = limits;
	}
	
	public void addRange(Double min, Double max) {
		limits.add(new LimitsDTO(min, max));
	}
}
