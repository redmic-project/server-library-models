package es.redmic.models.es.administrative.taxonomy.dto;

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

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.administrative.dto.DocumentCompactDTO;
import es.redmic.models.es.administrative.dto.DocumentDTO;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.taxonomy.dto.CanaryProtectionDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.EUProtectionDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.EcologyDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.EndemicityDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.InterestDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.OriginDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.PermanenceDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.SpainProtectionDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.TrophicRegimeDTO;

public class SpeciesDTO extends TaxonDTO {
	
	@Size(min = 0, max = 500)
	private String popularNames;

	@Size(min = 0, max = 250)
	private String groupicon;

	@Size(min = 0, max = 250)
	private String image;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = DocumentCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DOCUMENT")
	private DocumentDTO euDirective;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = DocumentCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DOCUMENT")
	private DocumentDTO canaryCatalogue;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSerialize(as = DocumentCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DOCUMENT")
	private DocumentDTO spainCatalogue;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ECOLOGY")
	private EcologyDTO ecology;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ENDEMICITY")
	private EndemicityDTO endemicity;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.INTEREST")
	private InterestDTO interest;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ORIGIN")
	private OriginDTO origin;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.PERMANENCE")
	private PermanenceDTO permanence;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.SPAIN_PROTECTION")
	private SpainProtectionDTO spainProtection;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.CANARY_PROTECTION")
	private CanaryProtectionDTO canaryProtection;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.EU_PROTECTION")
	private EUProtectionDTO euProtection;
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.TROPHIC_REGIME")
	private TrophicRegimeDTO trophicRegime;

	public SpeciesDTO() {
		super();
	}
	
	public String getPopularNames() {
		return popularNames;
	}

	public void setPopularNames(String popularNames) {
		this.popularNames = popularNames;
	}

	public String getGroupIcon() {
		return groupicon;
	}

	public void setGroupIcon(String groupicon) {
		this.groupicon = groupicon;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CanaryProtectionDTO getCanaryProtection() {
		return canaryProtection;
	}

	public void setCanaryProtection(CanaryProtectionDTO canaryProtection) {
		this.canaryProtection = canaryProtection;
	}
	
	public DocumentDTO getCanaryCatalogue() {
		return canaryCatalogue;
	}

	public void setCanaryCatalogue(DocumentDTO canaryCatalogue) {
		this.canaryCatalogue = canaryCatalogue;
	}

	public DocumentDTO getSpainCatalogue() {
		return spainCatalogue;
	}

	public void setSpainCatalogue(DocumentDTO spainCatalogue) {
		this.spainCatalogue = spainCatalogue;
	}

	public DocumentDTO getEuDirective() {
		return euDirective;
	}

	public void setEuDirective(DocumentDTO euDirective) {
		this.euDirective = euDirective;
	}

	public EcologyDTO getEcology() {
		return ecology;
	}

	public void setEcology(EcologyDTO ecology) {
		this.ecology = ecology;
	}

	public EndemicityDTO getEndemicity() {
		return endemicity;
	}

	public void setEndemicity(EndemicityDTO endemicity) {
		this.endemicity = endemicity;
	}

	public EUProtectionDTO getEuProtection() {
		return euProtection;
	}

	public void setEuProtection(EUProtectionDTO euProtection) {
		this.euProtection = euProtection;
	}

	public InterestDTO getInterest() {
		return interest;
	}

	public void setInterest(InterestDTO interest) {
		this.interest = interest;
	}

	public OriginDTO getOrigin() {
		return origin;
	}

	public void setOrigin(OriginDTO origin) {
		this.origin = origin;
	}

	public PermanenceDTO getPermanence() {
		return permanence;
	}

	public void setPermanence(PermanenceDTO permanence) {
		this.permanence = permanence;
	}

	public SpainProtectionDTO getSpainProtection() {
		return spainProtection;
	}

	public void setSpainProtection(SpainProtectionDTO spainProtection) {
		this.spainProtection = spainProtection;
	}

	public TrophicRegimeDTO getTrophicRegime() {
		return trophicRegime;
	}

	public void setTrophicRegime(TrophicRegimeDTO trophicRegime) {
		this.trophicRegime = trophicRegime;
	}
}
