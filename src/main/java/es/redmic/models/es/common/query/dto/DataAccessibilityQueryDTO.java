package es.redmic.models.es.common.query.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonFilter("DataQueryDTO")
@JsonSchemaNotNull
public class DataAccessibilityQueryDTO extends MetadataQueryDTO {

	public DataAccessibilityQueryDTO() {
		super();
	}

	@JsonView(value = { JsonViewsForQueryDTO.Administrator.class })
	@Size(max = 4)
	@JsonSchemaDefault("[2]")
	private List<Long> accessibilityIds;

	public List<Long> getAccessibilityIds() {
		return accessibilityIds;
	}

	public void setAccessibilityIds(List<Long> accessibilityIds) {
		this.accessibilityIds = accessibilityIds;
	}

	public void addAccessibilityIds(List<Long> accessibilityIds) {

		if (accessibilityIds != null && accessibilityIds.size() > 0) {

			if (this.accessibilityIds == null)
				this.accessibilityIds = new ArrayList<Long>();

			this.accessibilityIds.addAll(accessibilityIds);
		}
	}
}