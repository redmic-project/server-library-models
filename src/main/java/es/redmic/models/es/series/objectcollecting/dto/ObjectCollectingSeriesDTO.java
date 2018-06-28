package es.redmic.models.es.series.objectcollecting.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.geojson.common.domain.dto.ConfidenceDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectClassificationDTO;
import es.redmic.models.es.series.common.dto.SeriesBaseDTO;

public class ObjectCollectingSeriesDTO extends SeriesBaseDTO {
	
	private Double z;

	private Double deviation;
	
	@JsonSchemaIgnore
	@JsonIgnoreProperties(value = {"_meta"})
	//@NotNull
	//@Size(min=1, max=5)
	//@Valid
	private List<ObjectClassificationDTO> object;
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.CONFIDENCE")
	@JsonSchemaDefault(value = "1")
	private ConfidenceDTO confidence;
	
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

	public List<ObjectClassificationDTO> getObject() {
		return object;
	}

	public void setObject(List<ObjectClassificationDTO> object) {
		
		if (object != null && object.size() != 0)
			this.object = object;
	}

	public ConfidenceDTO getConfidence() {
		return confidence;
	}

	public void setConfidence(ConfidenceDTO confidence) {
		this.confidence = confidence;
	}
}
