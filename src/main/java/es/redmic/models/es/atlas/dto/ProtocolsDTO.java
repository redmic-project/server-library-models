package es.redmic.models.es.atlas.dto;

import javax.validation.constraints.NotNull;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaFormat;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;
import es.redmic.models.es.common.dto.DTOImplement;

@JsonSchemaNotNull
public class ProtocolsDTO extends DTOImplement {

	@NotNull
	private String type;
	
	@JsonSchemaFormat("url")
	@ValidateUrl()
	@NotNull
	private String url;

	public ProtocolsDTO() {
	}
	
	public ProtocolsDTO(String type, String urlSource) {
		
		createProtocols(type, urlSource);
	}

	public void createProtocols(String type, String urlSource) {
		
		
		if (type == null || !type.equals("WMS"))
			return;
		
		setType(type);
		
		if (urlSource == null)
			return;
		
		setUrl(urlSource);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
