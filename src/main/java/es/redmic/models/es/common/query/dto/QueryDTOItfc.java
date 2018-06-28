package es.redmic.models.es.common.query.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public interface QueryDTOItfc {

	public void checkFieldsExcludedOnQuery();

	public void createSimpleQueryDTOFromTextQueryParams(String[] fields, String text, Integer from, Integer size);

	public void createSimpleQueryDTOFromSuggestQueryParams(String[] fields, String text, Integer size);

	public void addAccessibilityIds(List<Long> accessibilities);

	public void setFieldsExcludedOnQuery(Set<String> fieldsExcludedOnQuery);

	public void setFixedQuery(Map<String, Object> fixedQuery);

	public void setDataType(String type);

	@JsonIgnore
	@JsonSchemaIgnore
	public default List<AggsPropertiesDTO> getAggs() {
		return null;
	}

	@JsonIgnore
	@JsonSchemaIgnore
	public default Map<String, String[]> getPostFilter() {
		return null;
	}
}
