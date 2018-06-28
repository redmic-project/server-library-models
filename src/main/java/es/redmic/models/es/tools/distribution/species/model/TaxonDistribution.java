package es.redmic.models.es.tools.distribution.species.model;

import java.util.List;

import es.redmic.models.es.common.model.BasePathAbstractES;
import es.redmic.models.es.tools.distribution.model.Register;

public class TaxonDistribution extends BasePathAbstractES{
	
	private String scientificName;
	private String authorship;
	private String equivalent;
	
	private List<Register> registers;
	
	public List<Register> getRegisters() {
		return registers;
	}
	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}
	
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String getAuthorship() {
		return authorship;
	}
	public void setAuthorship(String authorship) {
		this.authorship = authorship;
	}
	public String getEquivalent() {
		return equivalent;
	}
	public void setEquivalent(String equivalent) {
		this.equivalent = equivalent;
	}
	
}
