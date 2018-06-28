package es.redmic.models.es.common.query.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public class ValueQueryDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	private Double op;
	
	//Equal, NotEqual, Greater, Less, GreaterOrEqual, LessOrEqual
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	private RangeOperator operator;

	public Double getOp() {
		return op;
	}

	public ValueQueryDTO setOp(Double op) {
		this.op = op;
		return this;
	}

	public RangeOperator getOperator() {
		return operator;
	}

	public ValueQueryDTO setOperator(RangeOperator operator) {
		this.operator = operator;
		return this;
	}
}
