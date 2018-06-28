package es.redmic.models.es.tools.distribution.dto;

import java.util.ArrayList;
import java.util.List;

import es.redmic.models.es.administrative.taxonomy.model.TaxonValid;
import es.redmic.models.es.geojson.citation.dto.CitationDTO;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingDTO;

public class TaxonDistributionRegistersDTO extends TaxonValid {
	
	public TaxonDistributionRegistersDTO() {
		
		this.citations = new ArrayList<CitationDTO>();
		this.animalTrackings = new ArrayList<AnimalTrackingDTO>();
	}
	
	List<CitationDTO> citations;
	
	List<AnimalTrackingDTO> animalTrackings;
	
	Boolean misidentification = false;

	public List<CitationDTO> getCitations() {
		return citations;
	}

	public void setCitations(List<CitationDTO> citations) {
		this.citations = citations;
	}

	public List<AnimalTrackingDTO> getAnimalTrackings() {
		return animalTrackings;
	}

	public void setAnimalTrackings(List<AnimalTrackingDTO> animalTrackings) {
		this.animalTrackings = animalTrackings;
	}

	public Boolean getMisidentification() {
		return misidentification;
	}

	public void setMisidentification(Boolean misidentification) {
		this.misidentification = misidentification;
	}
}
