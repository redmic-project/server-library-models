package es.redmic.models.es.common.query.dto;

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