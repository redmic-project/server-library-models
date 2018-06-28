package es.redmic.models.es.series.objectcollecting.dto;

public class IntervalAggregationDTO extends CategoriesDTO {
	
	public IntervalAggregationDTO() {
		setLevel(3);
	}

	private String timeInterval;

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}
}