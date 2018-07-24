package es.redmic.models.es.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.redmic.models.es.administrative.dto.ActivityDTO;
import es.redmic.models.es.administrative.dto.ProgramDTO;
import es.redmic.models.es.administrative.dto.ProjectDTO;
import es.redmic.models.es.atlas.dto.LayerDTO;
import es.redmic.models.es.geojson.area.dto.AreaDTO;
import es.redmic.models.es.geojson.citation.dto.CitationDTO;
import es.redmic.models.es.geojson.geofixedstation.dto.GeoFixedObjectCollectingSeriesDTO;
import es.redmic.models.es.geojson.geofixedstation.dto.GeoFixedTimeSeriesDTO;
import es.redmic.models.es.geojson.infrastructure.dto.InfrastructureDTO;
import es.redmic.models.es.geojson.isolines.dto.IsolinesDTO;
import es.redmic.models.es.geojson.toponym.dto.ToponymDTO;
import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingDTO;
import es.redmic.models.es.geojson.tracking.common.ElementTrackingDTO;
import es.redmic.models.es.geojson.tracking.platform.dto.PlatformTrackingDTO;
import es.redmic.models.es.series.objectcollecting.dto.ObjectCollectingSeriesDTO;
import es.redmic.models.es.series.timeseries.dto.TimeSeriesDTO;

@SuppressWarnings("serial")
public final class DataPrefixType {

	// @formatter:off
	
	public static final String CITATION = "ci",
			ANIMAL_TRACKING = "at",
			PLATFORM_TRACKING = "pt",
			TRACKING = "tr",
			FIXED_TIMESERIES = "ft",
			OBJECT_COLLECTING = "oc",
			INFRASTRUCTURE = "if",
			ISOLINES = "il",
			AREA = "ar",
			TOPONYM = "tp",
			TIMESERIES = "ts",
			COLLECTINGSERIES = "cs",
			ACTIVITY = "ac",
			PROJECT = "pj",
			PROGRAM = "pg",
			LAYERS = "ly",
			OTHER = "ot";
	
	// @formatter:on

	protected static final Map<Class<?>, Type> classesHash;
	static {

		classesHash = new HashMap<Class<?>, Type>();
		classesHash.put(GeoFixedObjectCollectingSeriesDTO.class, new Type(OBJECT_COLLECTING, 32L));
		classesHash.put(GeoFixedTimeSeriesDTO.class, new Type(FIXED_TIMESERIES, new ArrayList<Long>() {
			{
				add(4L);
				add(5L);
				add(6L);
				add(7L);
				add(31L);
			}
		}));
		classesHash.put(CitationDTO.class, new Type(CITATION, 10L));

		// Tracking
		classesHash.put(AnimalTrackingDTO.class, new Type(ANIMAL_TRACKING, 13L));
		classesHash.put(PlatformTrackingDTO.class, new Type(PLATFORM_TRACKING, new ArrayList<Long>() {
			{
				add(7L);
				add(13L);
			}
		}));
		classesHash.put(ElementTrackingDTO.class, new Type(TRACKING, new ArrayList<Long>() {
			{
				add(7L);
				add(13L);
			}
		}));

		classesHash.put(InfrastructureDTO.class, new Type(INFRASTRUCTURE, 19L));
		classesHash.put(IsolinesDTO.class, new Type(ISOLINES, 21L));
		classesHash.put(AreaDTO.class, new Type(AREA, new ArrayList<Long>() {
			{
				add(15L);
				add(18L);
				add(19L);
				add(20L);
				add(46L);
			}
		}));
		classesHash.put(ToponymDTO.class, new Type(TOPONYM));
		classesHash.put(TimeSeriesDTO.class, new Type(TIMESERIES));
		classesHash.put(ObjectCollectingSeriesDTO.class, new Type(COLLECTINGSERIES));
		classesHash.put(LayerDTO.class, new Type(LAYERS));
		classesHash.put(ActivityDTO.class, new Type(ACTIVITY));
		classesHash.put(ProjectDTO.class, new Type(PROJECT));
		classesHash.put(ProgramDTO.class, new Type(PROGRAM));

	}

	public static String getPrefixTypeFromClass(Class<?> clazz) {

		if (classesHash.containsKey(clazz))
			return classesHash.get(clazz).getActivityCategory();
		return OTHER;
	}

	public static List<Long> getActivityTypesFromClass(Class<?> clazz) {

		if (classesHash.containsKey(clazz))
			return classesHash.get(clazz).getActivityTypes();
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static List<String> getActivityCategoriesByActivityType(Long activityTypeId) {

		List<String> activityCategories = new ArrayList<>();

		for (Map.Entry entry : classesHash.entrySet()) {

			Type value = (Type) entry.getValue();

			if (value.getActivityTypes() != null && value.getActivityTypes().contains(activityTypeId)) {
				activityCategories.add(value.getActivityCategory());
			}
		}
		return activityCategories;
	}
}