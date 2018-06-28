package es.redmic.models.es.administrative.taxonomy.model;

public class TaxonCompact extends TaxonAncestorsCompact {

	private String commonName;
	private Integer aphia;
	private Integer leaves = 0;

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	
	public Integer getAphia() {
		return aphia;
	}

	public void setAphia(Integer aphia) {
		this.aphia = aphia;
	}
	
	public Integer getLeaves() {
		return leaves;
	}

	public void setLeaves(Integer leaves) {
		this.leaves = leaves;
	}
}
