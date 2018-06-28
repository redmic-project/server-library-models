package es.redmic.models.es.atlas;

import javax.validation.constraints.NotNull;

import org.geotools.data.ows.CRSEnvelope;

public class LatLonBoundingBox {

	@NotNull
	private Double minX;
	@NotNull
	private Double minY;
	@NotNull
	private Double maxX;
	@NotNull
	private Double maxY;

	public LatLonBoundingBox() {
	}

	public LatLonBoundingBox(CRSEnvelope latLonBoundingBox) {

		setMinX(latLonBoundingBox.getMinX());
		setMinY(latLonBoundingBox.getMinY());
		setMaxX(latLonBoundingBox.getMaxX());
		setMaxY(latLonBoundingBox.getMaxY());
	}

	public Double getMinX() {
		return minX;
	}

	public void setMinX(Double minX) {
		this.minX = minX;
	}

	public Double getMinY() {
		return minY;
	}

	public void setMinY(Double minY) {
		this.minY = minY;
	}

	public Double getMaxX() {
		return maxX;
	}

	public void setMaxX(Double maxX) {
		this.maxX = maxX;
	}

	public Double getMaxY() {
		return maxY;
	}

	public void setMaxY(Double maxY) {
		this.maxY = maxY;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof LatLonBoundingBox))
			return false;

		LatLonBoundingBox b = getClass().cast(obj);
		return this.minX.equals(b.getMinX()) && this.minY.equals(b.getMinY()) && this.maxX.equals(b.getMaxX())
				&& this.maxY.equals(b.getMaxY());
	}
}