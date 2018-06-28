package es.redmic.test.unit.common.jsonschemagenerator;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonFilter("DataQueryDTO")
@JsonSchemaNotNull
public class Query {
	
	public Query() {
		
	}
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	private Integer from;
	
	@JsonView(value={JsonViewsForQueryDTO.Owner.class})
	private Integer size;
	
	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}