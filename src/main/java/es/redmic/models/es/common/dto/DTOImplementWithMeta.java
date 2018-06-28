package es.redmic.models.es.common.dto;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public abstract class DTOImplementWithMeta extends DTOImplement {

	@JsonSchemaIgnore
	private MetaDataDTO _meta = new MetaDataDTO();

	public MetaDataDTO get_meta() {
		return _meta;
	}

	public void set_meta(MetaDataDTO _meta) {
		this._meta = _meta;
	}
}
