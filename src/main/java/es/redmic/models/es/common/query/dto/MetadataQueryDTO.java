package es.redmic.models.es.common.query.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonSchemaNotNull
public class MetadataQueryDTO extends SimpleQueryDTO {

	public MetadataQueryDTO() {
		super();
	}
	
	// Metadata
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private Map<String, String[]> postFilter;

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@Valid
	private List<AggsPropertiesDTO> aggs;
	
	public Map<String, String[]> getPostFilter() {
		return postFilter;
	}

	public void setPostFilter(Map<String, String[]> postFilter) {
		this.postFilter = postFilter;
	}

	public List<AggsPropertiesDTO> getAggs() {
		return aggs;
	}

	public void setAggs(List<AggsPropertiesDTO> aggs) {
		this.aggs = aggs;
	}
	
	public void addAgg(AggsPropertiesDTO agg) {
		if (this.aggs == null)
			this.aggs = new ArrayList<AggsPropertiesDTO>();
		this.aggs.add(agg);
	}
}
