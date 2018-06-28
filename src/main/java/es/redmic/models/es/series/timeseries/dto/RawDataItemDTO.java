package es.redmic.models.es.series.timeseries.dto;

public class RawDataItemDTO {

	private String date;
	private Double value;
	
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}	
}
