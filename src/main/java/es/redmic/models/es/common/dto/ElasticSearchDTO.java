package es.redmic.models.es.common.dto;

import java.util.List;

import es.redmic.models.es.geojson.common.dto.GeoJSONFeatureCollectionDTO;

public class ElasticSearchDTO extends SuperDTO {

	Object body;
	int total;

	public ElasticSearchDTO(JSONCollectionDTO result) {
		super(true);
		this.body = result;
		this.total = result.getTotal();
	}
	
	public ElasticSearchDTO(GeoJSONFeatureCollectionDTO result) {
		super(true);
		this.body = result;
		this.total = result.getTotal();
	}
	
	public ElasticSearchDTO(List<?> data) {
		super(true);
		this.body = data;
		this.total = data.size();
	}

	public ElasticSearchDTO(Object data, int total) {
		super(true);
		this.body = data;
		this.total = total;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object result) {
		this.body = result;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
