package es.redmic.models.es.geojson.citation.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.administrative.taxonomy.dto.MisidentificationCompactDTO;
import es.redmic.models.es.administrative.taxonomy.dto.MisidentificationDTO;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonBaseDTO;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geojson.common.domain.dto.ConfidenceDTO;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;

@JsonSchemaNotNull
public class CitationPropertiesDTO extends PropertiesDTO {

	private Double z;

	private Double deviation;

	@NotNull
	private DateTime startDate;

	@NotNull
	private DateTime endDate;

	@Size(min = 0, max = 150)
	private String collectorname;

	// Notas
	@Size(min = 0, max = 1500)
	private String remark;

	private Long specimencount;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.CONFIDENCE")
	@JsonSchemaDefault(value = "1")
	private ConfidenceDTO confidence;

	@NotNull
	private Double radius;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.CONFIDENCE")
	@JsonSchemaDefault(value = "1")
	private ConfidenceDTO speciesConfidence;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonSerialize(as = TaxonBaseDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.SPECIES")
	private TaxonDTO taxon;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSerialize(as = MisidentificationCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.MISIDENTIFICATION")
	private MisidentificationDTO misidentification;

	public CitationPropertiesDTO() {
		super();
	}

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

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getEndDate() {
		return endDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public String getCollectorName() {
		return collectorname;
	}

	public void setCollectorName(String collectorname) {
		this.collectorname = collectorname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpecimenCount() {
		return specimencount;
	}

	public void setSpecimenCount(Long specimencount) {
		this.specimencount = specimencount;
	}

	public ConfidenceDTO getConfidence() {
		return confidence;
	}

	public void setConfidence(ConfidenceDTO confidence) {
		this.confidence = confidence;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public ConfidenceDTO getSpeciesConfidence() {
		return speciesConfidence;
	}

	public void setSpeciesConfidence(ConfidenceDTO speciesconfidence) {
		this.speciesConfidence = speciesconfidence;
	}

	public TaxonDTO getTaxon() {
		return taxon;
	}

	public void setTaxon(TaxonDTO taxonrecord) {
		this.taxon = taxonrecord;
	}

	public MisidentificationDTO getMisidentification() {
		return misidentification;
	}

	public void setMisidentification(MisidentificationDTO misidentification) {
		this.misidentification = misidentification;
	}
}
