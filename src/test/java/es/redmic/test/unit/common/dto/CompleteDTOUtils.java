package es.redmic.test.unit.common.dto;

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

import org.joda.time.DateTime;

import es.redmic.models.es.administrative.dto.ActivityBaseDTO;
import es.redmic.models.es.administrative.dto.ActivityDTO;
import es.redmic.models.es.administrative.dto.ContactDTO;
import es.redmic.models.es.administrative.dto.DocumentDTO;
import es.redmic.models.es.administrative.dto.OrganisationDTO;
import es.redmic.models.es.administrative.dto.PlatformDTO;
import es.redmic.models.es.administrative.dto.ProgramDTO;
import es.redmic.models.es.administrative.dto.ProjectDTO;
import es.redmic.models.es.administrative.taxonomy.dto.AnimalDTO;
import es.redmic.models.es.administrative.taxonomy.dto.KingdomDTO;
import es.redmic.models.es.administrative.taxonomy.dto.SpeciesDTO;
import es.redmic.models.es.administrative.taxonomy.dto.TaxonDTO;
import es.redmic.models.es.common.dto.DomainImplDTO;
import es.redmic.models.es.geojson.area.dto.AreaPropertiesDTO;
import es.redmic.models.es.geojson.citation.dto.CitationPropertiesDTO;
import es.redmic.models.es.geojson.common.domain.dto.ConfidenceDTO;
import es.redmic.models.es.geojson.infrastructure.dto.InfrastructurePropertiesDTO;
import es.redmic.models.es.geojson.isolines.dto.IsolinesPropertiesDTO;
import es.redmic.models.es.maintenance.administrative.dto.ActivityFieldDTO;
import es.redmic.models.es.maintenance.administrative.dto.ActivityTypeDTO;
import es.redmic.models.es.maintenance.administrative.dto.DocumentTypeDTO;
import es.redmic.models.es.maintenance.administrative.dto.OrganisationTypeDTO;
import es.redmic.models.es.maintenance.administrative.dto.PlatformTypeDTO;
import es.redmic.models.es.maintenance.administrative.dto.ProjectGroupDTO;
import es.redmic.models.es.maintenance.administrative.dto.RoleDTO;
import es.redmic.models.es.maintenance.administrative.dto.ThemeInspireDTO;
import es.redmic.models.es.maintenance.areas.dto.AreaClassificationDTO;
import es.redmic.models.es.maintenance.areas.dto.ThematicTypeBaseDTO;
import es.redmic.models.es.maintenance.areas.dto.ThematicTypeDTO;
import es.redmic.models.es.maintenance.common.dto.AccessibilityDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceDTO;
import es.redmic.models.es.maintenance.device.dto.DeviceTypeDTO;
import es.redmic.models.es.maintenance.line.dto.LineTypeBaseDTO;
import es.redmic.models.es.maintenance.line.dto.LineTypeDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectClassificationDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectCollectingDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectTypeBaseDTO;
import es.redmic.models.es.maintenance.objects.dto.ObjectTypeDTO;
import es.redmic.models.es.maintenance.parameter.dto.DataDefinitionDTO;
import es.redmic.models.es.maintenance.parameter.dto.ParameterDTO;
import es.redmic.models.es.maintenance.parameter.dto.ParameterTypeDTO;
import es.redmic.models.es.maintenance.parameter.dto.ParameterUnitDTO;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.models.es.maintenance.parameter.dto.UnitTypeDTO;
import es.redmic.models.es.maintenance.point.dto.InfrastructureTypeBaseDTO;
import es.redmic.models.es.maintenance.point.dto.InfrastructureTypeDTO;
import es.redmic.models.es.maintenance.qualifiers.dto.AttributeTypeDTO;
import es.redmic.models.es.maintenance.survey.dto.FixedSurveyDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.RankDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.StatusDTO;
import es.redmic.models.es.series.common.dto.DataDefinitionSeriesDTO;
import es.redmic.models.es.series.common.dto.HierarchicalParameterDTO;
import es.redmic.models.es.series.common.dto.MeasurementDTO;
import es.redmic.models.es.series.objectcollecting.dto.ObjectCollectingSeriesDTO;

public class CompleteDTOUtils {

	/*********/
	// Administrative
	/********/

	public static ActivityBaseDTO completeActivityBaseDTO() {

		ActivityBaseDTO activityBaseDTO = new ActivityBaseDTO();

		activityBaseDTO.setName("name");
		activityBaseDTO.setCode("code");
		activityBaseDTO.setDescription("description");
		activityBaseDTO.setAccessibility((AccessibilityDTO) completeObjectDomain(new AccessibilityDTO()));

		activityBaseDTO.setStartDate(new DateTime("2015-03-17T00:00:00.000Z"));
		activityBaseDTO.setEndDate(null);

		return activityBaseDTO;
	}

	public static ActivityDTO completeActivityDTO() {

		ActivityDTO activityDTO = new ActivityDTO();

		activityDTO.setName("name");
		activityDTO.setAccessibility((AccessibilityDTO) completeObjectDomain(new AccessibilityDTO()));

		ActivityTypeDTO activityTypeDTO = new ActivityTypeDTO();

		activityTypeDTO.setName("name");
		activityTypeDTO.setName_en("name");

		ActivityFieldDTO activityFieldDTO = new ActivityFieldDTO();

		ThemeInspireDTO themeInspire = new ThemeInspireDTO();

		activityFieldDTO.setName("name");
		activityFieldDTO.setName_en("name");
		activityTypeDTO.setActivityField(activityFieldDTO);
		activityDTO.setActivityType(activityTypeDTO);
		activityDTO.setStartDate(new DateTime("2015-03-17T00:00:00.000Z"));
		activityDTO.setParent(completeProjectDTO());
		activityDTO.setGrandparent(completeProgramDTO());
		activityDTO.setThemeInspire(themeInspire);
		activityDTO.setLicence("licence");
		activityDTO.setNormative("normative");
		activityDTO.setSpatialExtension("spatialExtension");
		activityDTO.setStarred(false);
		activityDTO.setResources(new ArrayList<>());

		return activityDTO;
	}

	public static ProjectDTO completeProjectDTO() {

		ProjectDTO dto = new ProjectDTO();

		dto.setName("name");
		dto.setAccessibility((AccessibilityDTO) completeObjectDomain(new AccessibilityDTO()));
		dto.setProjectGroup(((ProjectGroupDTO) completeObjectDomain(new ProjectGroupDTO())));
		dto.setStartDate(new DateTime("2015-03-17T00:00:00.000Z"));
		dto.setParent(completeProgramDTO());

		return dto;
	}

	public static ProgramDTO completeProgramDTO() {

		ProgramDTO dto = new ProgramDTO();

		AccessibilityDTO accessibilityDTO = new AccessibilityDTO();

		accessibilityDTO.setName("name");
		accessibilityDTO.setName_en("name_en");

		dto.setName("name");
		dto.setAccessibility(accessibilityDTO);

		dto.setStartDate(new DateTime("2015-03-17T00:00:00.000Z"));

		return dto;
	}

	public static ContactDTO completeContactDTO() {

		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setFirstName("name");
		contactDTO.setSurname("name_en");

		return contactDTO;
	}

	public static DocumentDTO completeDocumentDTO() {

		DocumentDTO documentDTO = new DocumentDTO();

		documentDTO.setTitle("title");
		documentDTO.setYear(2000);
		documentDTO.setAuthor("author");
		documentDTO.setSource("source");
		documentDTO.setLanguage("es");
		documentDTO.setEnabled(true);
		documentDTO.setPrivateInternalUrl(true);

		DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();
		documentTypeDTO.setName("name");
		documentTypeDTO.setName_en("name_en");
		documentDTO.setDocumentType(documentTypeDTO);

		return documentDTO;
	}

	public static OrganisationDTO completeOrganisationDTO() {

		OrganisationDTO organisationDTO = new OrganisationDTO();

		organisationDTO.setName("name");

		organisationDTO.setOrganisationType((OrganisationTypeDTO) completeObjectDomain(new OrganisationTypeDTO()));

		return organisationDTO;
	}

	public static PlatformDTO completePlatformDTO() {

		PlatformDTO platformDTO = new PlatformDTO();
		platformDTO.setName("name");
		platformDTO.setPlatformType(((PlatformTypeDTO) completeObjectDomain(new PlatformTypeDTO())));
		return platformDTO;
	}

	public static DeviceDTO completeDeviceDTO() {

		DeviceDTO dto = new DeviceDTO();
		dto.setName("name");
		dto.setDeviceType((DeviceTypeDTO) completeObjectDomain(new DeviceTypeDTO()));
		return dto;
	}

	public static ParameterDTO completeParameterDTO() {

		ParameterDTO dto = new ParameterDTO();

		dto.setName("name");
		dto.setName_en("name_en");

		dto.setParameterType((ParameterTypeDTO) CompleteDTOUtils.completeObjectDomain(new ParameterTypeDTO()));
		List<ParameterUnitDTO> units = new ArrayList<ParameterUnitDTO>();
		ParameterUnitDTO parameterUnitDTO = new ParameterUnitDTO();
		parameterUnitDTO.setId(1L);
		parameterUnitDTO.setUnit(completeUnitDTO());
		units.add(parameterUnitDTO);
		dto.setUnits(units);

		return dto;
	}

	public static UnitDTO completeUnitDTO() {

		UnitDTO unit = new UnitDTO();
		unit.setId(1L);
		unit.setName("Grados centígrados");
		unit.setName_en("Name_en");
		unit.setAcronym("acronym");

		UnitTypeDTO unitType = new UnitTypeDTO();
		unitType.setId(1L);

		unit.setUnitType(unitType);
		return unit;
	}

	public static AttributeTypeDTO completeAttributeTypeDTO() {

		AttributeTypeDTO dto = new AttributeTypeDTO();
		dto.setName("name");
		dto.setName_en("name_en");
		dto.setDescription("description");
		dto.setCode("code");
		return dto;
	}

	public static LineTypeDTO completeLineTypeDTO() {

		LineTypeDTO dto = new LineTypeDTO();
		dto.setName("name");
		dto.setName_en("name_en");
		dto.setDescription("description");
		dto.setRemark("remark");
		return dto;
	}

	public static ObjectTypeDTO completeObjectTypeDTO() {

		ObjectTypeDTO dto = new ObjectTypeDTO();
		dto.setName("name");
		dto.setName_en("name_en");
		dto.setDescription("description");
		return dto;
	}

	public static InfrastructureTypeDTO completeInfrastructureTypeDTO() {

		InfrastructureTypeDTO dto = new InfrastructureTypeDTO();
		dto.setName("name");
		dto.setName_en("name_en");
		dto.setDescription("description");
		return dto;
	}

	public static RoleDTO completeRoleDTO() {

		RoleDTO roleDTO = new RoleDTO();

		roleDTO.setName("name");
		roleDTO.setName_en("name_en");

		return roleDTO;
	}

	public static DomainImplDTO completeObjectDomain(DomainImplDTO obj) {

		obj.setName("name");
		obj.setName_en("name_en");

		return obj;
	}

	/**************/
	// Taxonomy
	/**************/

	public static KingdomDTO completeKingdomDTO() {
		KingdomDTO dto = new KingdomDTO();
		dto.setScientificName("scientificName");
		dto.setStatus((StatusDTO) completeObjectDomain(new StatusDTO()));
		dto.setRank((RankDTO) completeObjectDomain(new RankDTO()));
		return dto;
	}

	public static AnimalDTO completeAnimalDTO() {

		AnimalDTO dto = new AnimalDTO();
		dto.setName("name");
		dto.setTaxon(completeTaxonDTO());
		return dto;
	}

	public static SpeciesDTO completeSpeciesDTO() {

		SpeciesDTO dto = new SpeciesDTO();
		dto.setScientificName("scientificname");
		dto.setStatus((StatusDTO) completeObjectDomain(new StatusDTO()));
		dto.setRank((RankDTO) completeObjectDomain(new RankDTO()));
		dto.setParent(completeTaxonDTO());

		return dto;
	}

	public static TaxonDTO completeTaxonDTO() {

		TaxonDTO dto = new TaxonDTO();
		dto.setScientificName("ScientificName");
		dto.setStatus((StatusDTO) completeObjectDomain(new StatusDTO()));
		dto.setRank((RankDTO) completeObjectDomain(new RankDTO()));
		dto.setParent(new TaxonDTO());
		return dto;
	}

	/*********/
	// Data
	/*********/

	public static FixedSurveyDTO completeSurveyStation() {

		FixedSurveyDTO station = new FixedSurveyDTO();
		station.setId(1L);
		station.setName("prueba");
		station.setCode("TGr00");
		station.setPath("r.TGr00");
		station.setPrefixType("pb");
		station.setDashboard("http://redmic.net/dashboard");

		return station;
	}

	public static HierarchicalParameterDTO completeHierarchicalParameter() {

		HierarchicalParameterDTO parameter = new HierarchicalParameterDTO();
		parameter.setId(1L);
		parameter.setName("Temperatura");
		parameter.setName_en("Temperatura");
		parameter.setPath("r.TGr00.1");

		ParameterTypeDTO parameterType = new ParameterTypeDTO();
		parameterType.setId(1L);
		parameter.setParameterType(parameterType);

		return parameter;
	}

	public static List<MeasurementDTO> completeMeasurementList() {

		List<MeasurementDTO> measurements = new ArrayList<MeasurementDTO>();
		MeasurementDTO measurement = new MeasurementDTO();
		measurement.setParameter(completeHierarchicalParameter());
		measurement.setUnit(completeUnitDTO());
		measurement.setDataDefinition(completeDataDefinitionSeries());
		measurements.add(measurement);

		return measurements;
	}

	public static DataDefinitionSeriesDTO completeDataDefinitionSeries() {

		DataDefinitionSeriesDTO dataDefinition = new DataDefinitionSeriesDTO();
		dataDefinition.setId(2L);
		dataDefinition.setPath("r.TGr00.1.2");
		dataDefinition.setDescription("Prueba");
		dataDefinition.setDevice(completeDeviceDTO());
		dataDefinition.setTimeInterval(1L);
		dataDefinition.setIsSerial(true);
		dataDefinition.setZ(-2.0);

		return dataDefinition;
	}

	public static DataDefinitionDTO completeDataDefinition() {

		DataDefinitionDTO dataDefinition = new DataDefinitionDTO();
		dataDefinition.setId(2L);
		dataDefinition.setPath("r.TGr00.1.2");
		dataDefinition.setDescription("Prueba");
		dataDefinition.setDevice(completeDeviceDTO());

		return dataDefinition;
	}

	public static CitationPropertiesDTO completeCitationPropertiesDTO() {

		CitationPropertiesDTO dto = new CitationPropertiesDTO();
		dto.setActivityId("r.1.2.3");

		dto.setStartDate(DateTime.now());
		dto.setEndDate(DateTime.now());

		ConfidenceDTO confidence = new ConfidenceDTO();
		confidence.setId(1L);
		confidence.setName("Baja");
		confidence.setName_en("Low");

		TaxonDTO taxon = new TaxonDTO();
		taxon.setId(1L);
		taxon.setScientificName("Zostera Noltai");
		taxon.setStatus((StatusDTO) completeObjectDomain(new StatusDTO()));
		taxon.setRank((RankDTO) completeObjectDomain(new RankDTO()));
		taxon.setParent(new TaxonDTO());

		dto.setTaxon(taxon);
		dto.setSpeciesConfidence(confidence);
		dto.setConfidence(confidence);
		dto.setRadius(50.0);

		return dto;
	}

	public static InfrastructurePropertiesDTO completeInfrastructurePropertiesDTO() {

		InfrastructurePropertiesDTO dto = new InfrastructurePropertiesDTO();

		dto.setActivityId("1");

		InfrastructureTypeBaseDTO infrastructureTypeBaseDTO = new InfrastructureTypeBaseDTO();
		infrastructureTypeBaseDTO.setName("name");
		infrastructureTypeBaseDTO.setName_en("name_en");

		dto.setInfrastructureType(infrastructureTypeBaseDTO);
		dto.setCode("code");

		return dto;
	}

	public static IsolinesPropertiesDTO completeIsolinesPropertiesDTO() {

		IsolinesPropertiesDTO dto = new IsolinesPropertiesDTO();

		dto.setActivityId("1");
		dto.setDataDefinition(completeDataDefinition());
		dto.setUnit(completeUnitDTO());
		dto.setParameter(completeHierarchicalParameter());

		LineTypeBaseDTO lineType = new LineTypeBaseDTO();
		lineType.setName("name");
		lineType.setName_en("name_en");
		dto.setLineType(lineType);

		return dto;
	}

	public static ThematicTypeDTO completeThematicTypeDTO() {

		ThematicTypeDTO dto = new ThematicTypeDTO();

		dto.setId(1L);
		dto.setName("name");
		dto.setName_en("name_en");

		return dto;
	}

	public static AreaClassificationDTO completeAreaClassificationDTO() {

		AreaClassificationDTO dto = new AreaClassificationDTO();

		dto.setId(1L);

		ThematicTypeBaseDTO thematicTypeBaseDTO = new ThematicTypeBaseDTO();

		dto.setId(1L);
		thematicTypeBaseDTO.setName("name");
		thematicTypeBaseDTO.setName_en("name_en");

		dto.setType(thematicTypeBaseDTO);

		dto.setStartDate(new DateTime("2015-03-17T00:00:00.000Z"));
		dto.setEndDate(null);

		return dto;
	}

	public static AreaPropertiesDTO completeAreaPropertiesDTO() {

		AreaPropertiesDTO dto = new AreaPropertiesDTO();
		dto.setName("name");
		dto.setActivityId("1");

		return dto;
	}

	public static ObjectCollectingSeriesDTO completeObjectCollectingSeriesDTO() {

		ObjectCollectingSeriesDTO dto = new ObjectCollectingSeriesDTO();

		dto.setDate(new DateTime());
		dto.setValue(1.0);

		List<ObjectCollectingDTO> classification = new ArrayList<ObjectCollectingDTO>();
		ObjectTypeBaseDTO obj = new ObjectTypeBaseDTO();
		obj.setId(1L);
		obj.setName("classification");
		obj.setCode("p-00");

		ObjectCollectingDTO objCollecting = new ObjectCollectingDTO();

		objCollecting.setObjectType(obj);
		classification.add(objCollecting);

		List<ObjectClassificationDTO> objects = new ArrayList<ObjectClassificationDTO>();
		ObjectClassificationDTO object = new ObjectClassificationDTO();
		object.setId(1L);
		object.setClassification(classification);
		objects.add(object);
		dto.setObject(objects);

		return dto;
	}
}
