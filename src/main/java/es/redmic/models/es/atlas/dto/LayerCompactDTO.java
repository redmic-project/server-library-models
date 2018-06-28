package es.redmic.models.es.atlas.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.atlas.LatLonBoundingBox;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;

public class LayerCompactDTO extends LayerCategoryDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.THEME_INSPIRE")
	private ThemeInspireDTO themeInspire;
	
	@Valid
	private LatLonBoundingBox latLonBoundsImage;
	
	@JsonSchemaUniqueItemsByRequiredProperties
	@Valid
	@NotNull
	@Size(min=1)
	private List<ProtocolsDTO> protocols;
	
	public LayerCompactDTO() {
		this.protocols = new ArrayList<ProtocolsDTO>();
	}
	
	public ThemeInspireDTO getThemeInspire() {
		return themeInspire;
	}

	public void setThemeInspire(ThemeInspireDTO themeInspire) {
		this.themeInspire = themeInspire;
	}
	
	public LatLonBoundingBox getLatLonBoundsImage() {
		return latLonBoundsImage;
	}

	public void setLatLonBoundsImage(LatLonBoundingBox latLonBoundsImage) {
		this.latLonBoundsImage = latLonBoundsImage;
	}

	public List<ProtocolsDTO> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<ProtocolsDTO> protocols) {
		this.protocols = protocols;
	}
}