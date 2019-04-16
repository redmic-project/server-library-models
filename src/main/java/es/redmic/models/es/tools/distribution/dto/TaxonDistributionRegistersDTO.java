package es.redmic.models.es.tools.distribution.dto;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
