package es.redmic.models.es.administrative.taxonomy.model;

import java.util.HashSet;

import es.redmic.models.es.administrative.model.DocumentCompact;
import es.redmic.models.es.common.model.DomainES;

public class Peculiarity {

	private DomainES endemicity;

	private DocumentCompact canaryCatalogue;

	private DomainES interest;

	private DomainES origin;

	private DomainES euProtection;

	private DomainES ecology;

	private DomainES spainProtection;

	private DomainES permanence;

	private DomainES canaryProtection;
	
	private DomainES trophicRegime;

	private DocumentCompact spainCatalogue;

	private DocumentCompact euDirective;
	
	private HashSet<String> popularNames;

	public Peculiarity() {

	}

	public DomainES getEndemicity() {
		return endemicity;
	}

	public void setEndemicity(DomainES endemicity) {
		this.endemicity = endemicity;
	}

	public DocumentCompact getCanaryCatalogue() {
		return canaryCatalogue;
	}

	public void setCanaryCatalogue(DocumentCompact canaryCatalogue) {
		this.canaryCatalogue = canaryCatalogue;
	}

	public DomainES getInterest() {
		return interest;
	}

	public void setInterest(DomainES interest) {
		this.interest = interest;
	}

	public DomainES getOrigin() {
		return origin;
	}

	public void setOrigin(DomainES origin) {
		this.origin = origin;
	}

	public DomainES getEuProtection() {
		return euProtection;
	}

	public void setEuProtection(DomainES euProtection) {
		this.euProtection = euProtection;
	}

	public DomainES getEcology() {
		return ecology;
	}

	public void setEcology(DomainES ecology) {
		this.ecology = ecology;
	}

	public DomainES getSpainProtection() {
		return spainProtection;
	}

	public void setSpainProtection(DomainES spainProtection) {
		this.spainProtection = spainProtection;
	}

	public DomainES getPermanence() {
		return permanence;
	}

	public void setPermanence(DomainES permanence) {
		this.permanence = permanence;
	}

	public DomainES getCanaryProtection() {
		return canaryProtection;
	}

	public void setCanaryProtection(DomainES canaryProtection) {
		this.canaryProtection = canaryProtection;
	}

	public DomainES getTrophicRegime() {
		return trophicRegime;
	}

	public void setTrophicRegime(DomainES trophicRegime) {
		this.trophicRegime = trophicRegime;
	}

	public DocumentCompact getSpainCatalogue() {
		return spainCatalogue;
	}

	public void setSpainCatalogue(DocumentCompact spainCatalogue) {
		this.spainCatalogue = spainCatalogue;
	}

	public DocumentCompact getEuDirective() {
		return euDirective;
	}

	public void setEuDirective(DocumentCompact euDirective) {
		this.euDirective = euDirective;
	}

	public HashSet<String> getPopularNames() {
		return popularNames;
	}

	public void setPopularNames(HashSet<String> popularNames) {
		this.popularNames = popularNames;
	}
}
