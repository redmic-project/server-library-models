package es.redmic.models.es.series.timeseries.dto;

import java.util.Map;

import es.redmic.models.es.common.dto.SettingsDTO;

public class TimeSeriesSettingsDTO extends SettingsDTO {

	private String name;
	private Map<String, Object> settings;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Object> getSettings() {
		return settings;
	}
	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}
}
