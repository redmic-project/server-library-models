package es.redmic.models.es.tools.distribution.model;

public class Register {
	
	private String id;
	
	private Long confidence;
	
	private String misidentification;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getConfidence() {
		return confidence;
	}
	public void setConfidence(Long confidence) {
		this.confidence = confidence;
	}
	public String getMisidentification() {
		return misidentification;
	}
	public void setMisidentification(String misidentification) {
		this.misidentification = misidentification;
	}
}
