package es.redmic.models.es.geodata.common.model;

public class PointCommonFields extends BaseAbstractGeoData {
	
	private Double z;
	
	private Double deviation;
	
	public Double getZ() {
		return z;
	}
	
	public void setZ(Double z) {
		this.z = z;
	}
	
	public Double getDeviation() {
		return deviation;
	}
	
	public void setDeviation(Double deviation) {
		this.deviation = deviation;
	}
}
