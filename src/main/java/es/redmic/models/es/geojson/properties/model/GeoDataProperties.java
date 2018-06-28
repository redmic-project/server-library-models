package es.redmic.models.es.geojson.properties.model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geodata.common.model.Media;
import es.redmic.models.es.geojson.common.model.Properties;
import es.redmic.models.es.series.timeseries.model.TimeSeries;

public class GeoDataProperties extends Properties {

	// Ids
	private List<String> geodataRelations;

	// campos para áreas o líneas
	private Double length;
	private Double area;

	private DateTime inserted;
	private DateTime updated;

	// Definición de un lugar de muestreo (área o línea)
	private SamplingPlace samplingPlace;

	// Listado de condiciones metereológicas
	private List<WeatherCondition> weatherConditions;

	// Listado de información de archivos multimédia
	private List<Media> media;

	// Información de un lugar o una infrastructura
	private Site site;

	// Información del punto del track
	private InTrack inTrack;

	// Información asociada a una recolecta de objetos o taxones
	private Collect collect;

	// Listado de información asociada a medidas realizadas
	private List<Measurement> measurements;

	// Se usa solamente para poder obtener los datos de la serie en el
	// repositorio principal
	// y guardar en el repositorio correspondiente (No se guarda)
	@JsonIgnore
	private List<TimeSeries> series;

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getInserted() {
		return inserted;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getUpdated() {
		return updated;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public SamplingPlace getSamplingPlace() {
		return samplingPlace;
	}

	public void setSamplingPlace(SamplingPlace samplingPlace) {
		this.samplingPlace = samplingPlace;
	}

	public List<WeatherCondition> getWeatherConditions() {
		return weatherConditions;
	}

	public void setWeatherConditions(List<WeatherCondition> weatherConditions) {
		this.weatherConditions = weatherConditions;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;

		if (measurements != null && measurements.size() > 0)
			generatePath();
	}

	public InTrack getInTrack() {
		return inTrack;
	}

	public void setInTrack(InTrack inTrack) {
		this.inTrack = inTrack;
	}

	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;

		if (site != null && measurements != null)
			generatePath();
	}

	@JsonIgnore
	public List<TimeSeries> getSeries() {
		return series;
	}

	@JsonIgnore
	public void setSeries(List<TimeSeries> series) {
		this.series = series;
	}

	public void addSeries(TimeSeries series) {
		if (this.series == null)
			this.series = new ArrayList<>();
		this.series.add(series);
	}

	private void generatePath() {
		int i, size = getMeasurements().size();
		for (i = 0; i < size; i++) {
			measurements.get(i).getParameter()
					.setPath(site.getPath() + "." + measurements.get(i).getParameter().getId());
			measurements.get(i).getDataDefinition().setPath(measurements.get(i).getParameter().getPath() + "."
					+ measurements.get(i).getDataDefinition().getId());
		}
	}

	public List<String> getGeodataRelations() {
		return geodataRelations;
	}

	public void setGeodataRelations(List<String> geodataRelations) {
		this.geodataRelations = geodataRelations;
	}
}
