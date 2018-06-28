package es.redmic.models.es.geojson.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.series.attributeseries.model.AttributeSeries;
import es.redmic.models.es.series.common.model.SeriesSearchWrapper;
import es.redmic.models.es.series.objectcollecting.model.ObjectCollectingSeries;
import es.redmic.models.es.series.timeseries.model.TimeSeries;

@JsonIgnoreProperties(ignoreUnknown=true)
public class InnerHits {

	SeriesSearchWrapper<TimeSeries> timeseries;
	SeriesSearchWrapper<ObjectCollectingSeries> collecting;
	SeriesSearchWrapper<AttributeSeries> attributeseries;
	
	public SeriesSearchWrapper<TimeSeries> getTimeseries() {
		return timeseries;
	}
	
	public void setTimeseries(SeriesSearchWrapper<TimeSeries> timeseries) {
		this.timeseries = timeseries;
	}
	
	public SeriesSearchWrapper<ObjectCollectingSeries> getCollecting() {
		return collecting;
	}
	
	public void setCollecting(SeriesSearchWrapper<ObjectCollectingSeries> collecting) {
		this.collecting = collecting;
	}
	
	public SeriesSearchWrapper<AttributeSeries> getAttributeseries() {
		return attributeseries;
	}
	
	public void setAttributeseries(SeriesSearchWrapper<AttributeSeries> attributeseries) {
		this.attributeseries = attributeseries;
	}
}
