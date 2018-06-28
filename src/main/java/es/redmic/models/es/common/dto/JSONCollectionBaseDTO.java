package es.redmic.models.es.common.dto;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public class JSONCollectionBaseDTO {
	
	private AggregationsDTO _aggs;
	
	@JsonSchemaIgnore
	private MetaDataCollectionDTO _meta;
	
	private Integer total;

	public JSONCollectionBaseDTO() {
		_meta = new MetaDataCollectionDTO();
		_aggs = new AggregationsDTO();
	}
	
	public AggregationsDTO get_aggs() {
		return _aggs;
	}

	public void set_aggs(AggregationsDTO _aggs) {
		this._aggs = _aggs;
	}

	public MetaDataCollectionDTO get_meta() {
		return _meta;
	}

	public void set_meta(MetaDataCollectionDTO _meta) {
		this._meta = _meta;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
