package es.redmic.models.es.maintenance.statistics.dto;

import javax.validation.constraints.Min;

public class ResultDTO {

	@Min(value = 0)
	private Integer open;

	@Min(value = 0)
	private Integer close;

	public ResultDTO() {

	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}

	public Integer getClose() {
		return close;
	}

	public void setClose(Integer close) {
		this.close = close;
	}
}