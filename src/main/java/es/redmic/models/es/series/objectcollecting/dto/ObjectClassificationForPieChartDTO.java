package es.redmic.models.es.series.objectcollecting.dto;

public class ObjectClassificationForPieChartDTO extends CategoriesDTO {

	private String name;
	
	private Integer value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
