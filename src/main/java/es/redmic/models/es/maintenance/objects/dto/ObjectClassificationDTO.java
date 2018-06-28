package es.redmic.models.es.maintenance.objects.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import es.redmic.models.es.common.dto.DTOImplement;

public class ObjectClassificationDTO extends DTOImplement {
	
	@NotNull
	@Valid
	List<ObjectCollectingDTO> classification;

	public List<ObjectCollectingDTO> getClassification() {
		return classification;
	}

	public void setClassification(List<ObjectCollectingDTO> classification) {
		this.classification = classification;
	}
}
