package es.redmic.models.es.geojson.properties.model;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.administrative.taxonomy.model.AnimalWithOutTaxon;
import es.redmic.models.es.administrative.taxonomy.model.MisidentificationCompact;
import es.redmic.models.es.administrative.taxonomy.model.TaxonValid;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geodata.ancillarydata.model.Analytic;
import es.redmic.models.es.geodata.ancillarydata.model.Metric;
import es.redmic.models.es.geodata.common.model.PointCommonFields;
import es.redmic.models.es.geodata.genomics.model.Molecular;
import es.redmic.models.es.geodata.misc.model.Element;
import es.redmic.models.es.geodata.qualifiers.model.Attribute;
import es.redmic.models.es.geodata.samples.model.Sample;
import es.redmic.models.es.maintenance.objects.model.ObjectClassification;
import es.redmic.models.es.maintenance.parameter.model.DataDefinition;

public class Collect extends PointCommonFields {
	
	private Double value;
	
	private Double radius;
	
	private Character qFlag;

	private Character vFlag;
	
	private String remark;
	
	private Double observationAngle;
	
	private Long distance;
	
	private String collectorName;
	
	private String collectionRegNo;
	
	private DomainES confidence;
	private DomainES localityConfidence;
	
	private DataDefinition dataDefinition;
	
	private TaxonValid taxon;
	
	private MisidentificationCompact misidentification;
	
	private AnimalWithOutTaxon animal;
	
	private List<ObjectClassification> object;

	private List<Analytic> analytics;
	
	private List<Attribute> attributes;
	
	private List<Metric> metrics;
	
	private List<Molecular> molecular;
	
	private List<Element> elements;
	
	private Sample sample;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime startDate;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime endDate;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	public Character getqFlag() {
		return qFlag;
	}

	public void setqFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	public Character getvFlag() {
		return vFlag;
	}

	public void setvFlag(Character vFlag) {
		this.vFlag = vFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getObservationAngle() {
		return observationAngle;
	}

	public void setObservationAngle(Double observationAngle) {
		this.observationAngle = observationAngle;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public String getCollectorName() {
		return collectorName;
	}

	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}

	public String getCollectionRegNo() {
		return collectionRegNo;
	}

	public void setCollectionRegNo(String collectionRegNo) {
		this.collectionRegNo = collectionRegNo;
	}

	public DomainES getConfidence() {
		return confidence;
	}

	public void setConfidence(DomainES confidence) {
		this.confidence = confidence;
	}

	public DomainES getLocalityConfidence() {
		return localityConfidence;
	}

	public void setLocalityConfidence(DomainES localityConfidence) {
		this.localityConfidence = localityConfidence;
	}
	
	public DataDefinition getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinition dataDefinition) {
		this.dataDefinition = dataDefinition;
	}

	public TaxonValid getTaxon() {
		return taxon;
	}

	public void setTaxon(TaxonValid taxon) {
		this.taxon = taxon;
	}

	public MisidentificationCompact getMisidentification() {
		return misidentification;
	}

	public void setMisidentification(MisidentificationCompact misidentification) {
		this.misidentification = misidentification;
	}

	public AnimalWithOutTaxon getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalWithOutTaxon animal) {
		this.animal = animal;
	}

	public List<ObjectClassification> getObject() {
		return object;
	}

	public void setObject(List<ObjectClassification> object) {
		this.object = object;
	}

	public List<Analytic> getAnalytics() {
		return analytics;
	}

	public void setAnalytics(List<Analytic> analytics) {
		this.analytics = analytics;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	public List<Molecular> getMolecular() {
		return molecular;
	}

	public void setMolecular(List<Molecular> molecular) {
		this.molecular = molecular;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}
	
	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startdate) {
		this.startDate = startdate;
	}
	
	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime enddate) {
		this.endDate = enddate;
	}
}