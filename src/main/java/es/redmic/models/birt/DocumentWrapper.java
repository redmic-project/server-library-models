package es.redmic.models.birt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.administrative.dto.ActivityDTO;
import es.redmic.models.es.administrative.dto.DocumentDTO;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentWrapper extends Wrapper {

	private DocumentDTO document;
	private List<ActivityDTO> activities;

	public DocumentWrapper() {
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public List<ActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityDTO> activities) {
		this.activities = activities;
	}
}