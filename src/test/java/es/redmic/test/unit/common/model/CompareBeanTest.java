package es.redmic.test.unit.common.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import es.redmic.exception.common.InternalException;
import es.redmic.models.es.administrative.taxonomy.model.TaxonValid;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.model.ReferencesES;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.properties.model.Collect;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;
import es.redmic.models.es.maintenance.administrative.model.ActivityType;
import es.redmic.models.es.maintenance.administrative.model.ActivityTypeCompact;

@RunWith(MockitoJUnitRunner.class)
public class CompareBeanTest {

	@Mock
	DomainES newModel;
	@Mock
	DomainES oldModel;

	@Mock
	ActivityType newNested;
	@Mock
	ActivityType oldNested;

	@Mock
	GeoPointData newCitation;
	@Mock
	GeoPointData oldCitation;

	@Mock
	GeoPointData newAnimalTracking;
	@Mock
	GeoPointData oldAnimalTracking;

	List<String> domainFieldsInReference = Arrays.asList(new String[] { "name_en", "name", "id" });

	List<String> nestedFieldsInReference = Arrays.asList(new String[] { "description", "activityField",
			"activityField.name_en", "activityField.name", "activityField.id", "name_en", "name", "id" });

	List<String> nestedCompactFieldsInReference = Arrays.asList(new String[] { "activityField", "activityField.name_en",
			"activityField.name", "activityField.id", "name_en", "name", "id" });

	private void initializeDomain() {
		newModel = new DomainES();

		newModel.setId(1L);
		newModel.setName("prueba");
		newModel.setName_en("prueba_en");

		oldModel = new DomainES();
		oldModel.setId(1L);
		oldModel.setName("prueba");
		oldModel.setName_en("prueba_en");
	}

	private void initializeNested() {

		oldNested = new ActivityType();
		oldNested.setActivityField(oldModel);
		oldNested.setId(1L);
		oldNested.setName("nested");

		newNested = new ActivityType();
		newNested.setActivityField(newModel);
		newNested.setId(1L);
		newNested.setName("nested");
	}

	private void initializeCitation() {

		GeometryFactory gf = new GeometryFactory();
		Point point = gf.createPoint(new Coordinate(1.2345678, 2.3456789));

		GeoDataProperties properties = new GeoDataProperties();
		TaxonValid taxon = new TaxonValid();
		taxon.setId(1L);
		taxon.setScientificName("old");

		Collect collect = new Collect();
		collect.setTaxon(taxon);
		properties.setCollect(collect);

		oldCitation = new GeoPointData();
		oldCitation.setProperties(properties);
		oldCitation.setId(1L);
		oldCitation.setGeometry(point);

		Point pointNew = gf.createPoint(new Coordinate(2.2345678, 3.3456789));

		GeoDataProperties propertiesNew = new GeoDataProperties();
		TaxonValid taxonNew = new TaxonValid();
		taxonNew.setId(1L);
		taxonNew.setScientificName("new");
		Collect collectNew = new Collect();
		collect.setTaxon(taxonNew);
		propertiesNew.setCollect(collectNew);

		newCitation = new GeoPointData();
		newCitation.setProperties(propertiesNew);
		newCitation.setId(1L);
		newCitation.setGeometry(pointNew);
	}

	@Before
	public void setUp() throws Exception {
		initializeDomain();
	}

	@Test
	public void compareBeanWhenAreEquals() {

		ReferencesES<DomainES> ref = new ReferencesES<DomainES>(oldModel, newModel);
		ref.setClassForMapping(DomainES.class);
		assertEquals(ref.getDifferences(), new ArrayList<String>());
	}

	@Test
	public void compareBeanWhenAreDifferents() {

		newModel.setName("pruebaNueva");
		ReferencesES<DomainES> ref = new ReferencesES<DomainES>(oldModel, newModel);
		ref.setClassForMapping(DomainES.class);
		List<String> result = new ArrayList<String>();
		result.add("name");
		assertEquals(ref.getDifferences(), Arrays.asList(new String[] { "name" }));
	}

	@Test
	public void compareNestedBeanWhenAreEquals() {

		initializeNested();
		ReferencesES<ActivityType> ref = new ReferencesES<ActivityType>(oldNested, newNested);
		ref.setClassForMapping(ActivityType.class);
		assertEquals(ref.getDifferences(), new ArrayList<String>());
	}

	@Test
	public void compareNestedBeanWhenAreDifferents() {

		newModel.setName("pruebaNueva");

		initializeNested();
		ReferencesES<ActivityType> ref = new ReferencesES<ActivityType>(oldNested, newNested);
		ref.setClassForMapping(ActivityType.class);
		assertEquals(ref.getDifferences(), Arrays.asList(new String[] { "activityField.name" }));
	}

	@Test
	public void getFieldsInDomianBean() {

		initializeDomain();
		ReferencesES<DomainES> ref = new ReferencesES<DomainES>(oldModel, newModel);
		ref.setClassForMapping(DomainES.class);
		assertEquals(ref.getFieldsInReference(), domainFieldsInReference);
	}

	@Test
	public void getFieldsInNestedBean() {

		initializeNested();
		ReferencesES<ActivityType> ref = new ReferencesES<ActivityType>(oldNested, newNested);
		ref.setClassForMapping(ActivityType.class);
		assertEquals(ref.getFieldsInReference(), nestedFieldsInReference);
	}

	@Test
	public void getFieldsInNestedCompactBean() {

		initializeNested();
		ReferencesES<ActivityType> ref = new ReferencesES<ActivityType>(oldNested, newNested);
		ref.setClassForMapping(ActivityTypeCompact.class);
		assertEquals(ref.getFieldsInReference(), nestedCompactFieldsInReference);
	}

	@Test
	public void getModelToIndexInNestedCompactBean() {

		initializeNested();
		ReferencesES<ActivityType> ref = new ReferencesES<ActivityType>(oldNested, newNested);
		ref.setClassForMapping(ActivityTypeCompact.class);
		assertEquals(ref.getModelToIndex().get("description"), null);
	}

	@Test
	public void getFieldsInRegisterBean() {

		initializeCitation();
		ReferencesES<GeoPointData> ref = new ReferencesES<GeoPointData>(oldCitation, newCitation);
		ref.setClassForMapping(GeoPointData.class);
		Assert.assertTrue(ref.getFieldsInReference().contains("properties.collect.taxon"));
		Assert.assertTrue(ref.getFieldsInReference().contains("properties.collect.taxon.validAs"));
		Assert.assertTrue(ref.getFieldsInReference().contains("properties.collect.taxon.validAs.scientificName"));
	}

	@Test
	public void compareRegisterBeanWhenAreDifferents() {

		initializeCitation();
		ReferencesES<GeoPointData> ref = new ReferencesES<GeoPointData>(oldCitation, newCitation);
		ref.setClassForMapping(GeoPointData.class);
		assertEquals(ref.getDifferences(), Arrays.asList(new String[] { "geometry", "properties.collect.taxon" }));
		assertEquals(ref.getDifferences().size(), 2);
	}

	@Test(expected = InternalException.class)
	public void getDifferences_ThrowExceptionsIfNotSetClassForMapping() {
		ReferencesES<DomainES> ref = new ReferencesES<DomainES>(oldModel, newModel);
		ref.getDifferences();
	}

}
