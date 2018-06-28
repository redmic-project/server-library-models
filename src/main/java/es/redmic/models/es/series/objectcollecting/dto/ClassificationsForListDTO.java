package es.redmic.models.es.series.objectcollecting.dto;

import java.util.ArrayList;
import java.util.List;

//TODO: cambiar a una base común para todas las clasificacioes, que se le pase el tipo del list. Ahora da problemas al pasarle el tipo al converter 
public class ClassificationsForListDTO {
	
	private List<ClassificationForListDTO> classification = new ArrayList<ClassificationForListDTO>();

	public List<ClassificationForListDTO> getClassification() {
		return classification;
	}

	public void setClassification(List<ClassificationForListDTO> classification) {
		this.classification = classification;
	}
}
