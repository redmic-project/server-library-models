package es.redmic.models.es.geojson.common.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.redmic.models.es.common.dto.JSONCollectionBaseDTO;
import es.redmic.models.es.geojson.GeoJSONFeatureCollectionType;

@JsonPropertyOrder(value = { "type", "features" })
public class GeoJSONFeatureCollectionDTO extends JSONCollectionBaseDTO {

	protected GeoJSONFeatureCollectionType type = GeoJSONFeatureCollectionType.FEATURE_COLLECTION;
	
	@SuppressWarnings("rawtypes")
	protected List features;

	private Long itemsInvolved;

	@SuppressWarnings("rawtypes")
	public GeoJSONFeatureCollectionDTO() {
		super();
		features = new ArrayList();
		setTotal(0);

	}

	@SuppressWarnings("unchecked")
	public void addFeature(Object obj) {
		features.add(obj);
	}

	public GeoJSONFeatureCollectionType getType() {
		return type;
	}

	public void setType(GeoJSONFeatureCollectionType type) {
		this.type = type;
	}

	@SuppressWarnings("rawtypes")
	public List getFeatures() {
		return features;
	}

	@SuppressWarnings("rawtypes")
	public void setFeatures(List features) {
		this.features = features;
		setTotal(features.size());
	}
	
	@JsonInclude(Include.NON_EMPTY)
	public Long getItemsInvolved() {
		return itemsInvolved;
	}

	public void setItemsInvolved(Long itemsInvolved) {
		this.itemsInvolved = itemsInvolved;
	}
}
