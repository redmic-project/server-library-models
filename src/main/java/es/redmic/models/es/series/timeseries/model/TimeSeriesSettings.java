package es.redmic.models.es.series.timeseries.model;

import java.util.Map;

import es.redmic.models.es.common.model.Settings;

public class TimeSeriesSettings extends Settings {

	private Map<String, Object> settings;

	public Map<String, Object> getSettings() {
		return settings;
	}

	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}
}
