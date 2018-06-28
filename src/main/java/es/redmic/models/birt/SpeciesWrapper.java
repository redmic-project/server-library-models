package es.redmic.models.birt;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.redmic.models.es.administrative.dto.ActivityDTO;
import es.redmic.models.es.administrative.dto.DocumentDTO;
import es.redmic.models.es.administrative.taxonomy.dto.SpeciesDTO;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeciesWrapper extends Wrapper {

	private SpeciesDTO species;
	private TaxonDTO kingdom;
	private TaxonDTO phylum;
	private TaxonDTO subphylum;
	@JsonProperty("class")
	private TaxonDTO classs;
	private TaxonDTO order;
	private TaxonDTO family;
	private TaxonDTO genus;
	private ArrayList<ActivityDTO> activities;
	private ArrayList<DocumentDTO> documents;

	public SpeciesWrapper() {
	}

	public SpeciesDTO getSpecies() {
		return species;
	}

	public void setSpecies(SpeciesDTO species) {
		this.species = species;
	}

	public TaxonDTO getKingdom() {
		return kingdom;
	}

	public void setKingdom(TaxonDTO kingdom) {
		this.kingdom = kingdom;
	}

	public TaxonDTO getPhylum() {
		return phylum;
	}

	public void setPhylum(TaxonDTO phylum) {
		this.phylum = phylum;
	}

	public TaxonDTO getSubphylum() {
		return subphylum;
	}

	public void setSubphylum(TaxonDTO subphylum) {
		this.subphylum = subphylum;
	}

	public TaxonDTO getClasss() {
		return classs;
	}

	public void setClasss(TaxonDTO classs) {
		this.classs = classs;
	}

	public TaxonDTO getOrder() {
		return order;
	}

	public void setOrder(TaxonDTO order) {
		this.order = order;
	}

	public TaxonDTO getFamily() {
		return family;
	}

	public void setFamily(TaxonDTO family) {
		this.family = family;
	}

	public TaxonDTO getGenus() {
		return genus;
	}

	public void setGenus(TaxonDTO genus) {
		this.genus = genus;
	}

	public ArrayList<ActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<ActivityDTO> activities) {
		this.activities = activities;
	}

	public ArrayList<DocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<DocumentDTO> documents) {
		this.documents = documents;
	}
}