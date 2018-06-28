package es.redmic.models.es.geojson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GeoJSONFeatureCollectionType implements BaseEnumType {
	
	FEATURE_COLLECTION(Constants.FEATURE_COLLECTION);

	final String type;

	GeoJSONFeatureCollectionType(String type) {
		this.type = type;
	}

	@JsonCreator
	public static GeoJSONFeatureCollectionType fromString(String text) {
		if (text != null) {
			for (GeoJSONFeatureCollectionType b : GeoJSONFeatureCollectionType.values()) {
				if (text.equalsIgnoreCase(b.type)) {
					return b;
				}
			}
		}
		throw new IllegalArgumentException(text + " has no corresponding value");
	}

	@JsonValue
	@Override
	public String toString() {
		return type;
	}
	
	public static class Constants {
		public static final String FEATURE_COLLECTION = "FeatureCollection";
	}
}