package es.redmic.models.es.common.query.dto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.validation.BindException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.exception.databinding.DTONotValidException;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonSchemaNotNull
public class SimpleQueryDTO implements QueryDTOItfc {

	public SimpleQueryDTO() {
		super();
	}

	// Default
	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@JsonSchemaDefault("0")
	private Integer from = 0;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@JsonSchemaDefault("100")
	private Integer size;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Map<String, Object> terms = new HashMap<String, Object>();

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private List<SortDTO> sorts;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private List<String> returnFields;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private TextQueryDTO text;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private SuggestQueryDTO suggest;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private List<RegexpDTO> regexp;

	@JsonIgnore
	@JsonSchemaIgnore
	private String dataType;

	@JsonIgnore
	@JsonSchemaIgnore
	private Set<String> fieldsExcludedOnQuery = new HashSet<>();

	@JsonIgnore
	@JsonSchemaIgnore
	private String[] defaultSearchFields;

	@JsonIgnore
	@JsonSchemaIgnore
	private String[] defaultHighlightFields;

	@JsonIgnore
	@JsonSchemaIgnore
	private String[] defaultSuggestFields;

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

	public Map<String, Object> getTerms() {
		return terms;
	}

	public void setTerms(Map<String, Object> terms) {
		this.terms = terms;
	}

	public void addTerm(String key, Object value) {
		if (this.terms == null)
			this.terms = new HashMap<String, Object>();
		this.terms.put(key, value);
	}

	public List<SortDTO> getSorts() {
		return sorts;
	}

	public void setSorts(List<SortDTO> sorts) {
		this.sorts = sorts;
	}

	public List<String> getReturnFields() {
		return returnFields;
	}

	public void setReturnFields(List<String> returnFields) {
		this.returnFields = returnFields;
	}

	public TextQueryDTO getText() {

		if (text != null) {

			if (text.getSearchFields() == null || text.getSearchFields().length == 0) {
				text.setSearchFields(getDefaultSearchFields());
			}

			if (text.getHighlightFields() == null || text.getHighlightFields().length == 0) {
				text.setHighlightFields(getDefaultHighlightFields());
			}
		}

		return text;
	}

	public void setText(TextQueryDTO text) {
		this.text = text;
	}

	public SuggestQueryDTO getSuggest() {

		if (suggest != null && suggest.getSearchFields() == null) {
			suggest.setSearchFields(getDefaultSuggestFields());
		}

		return suggest;
	}

	public void setSuggest(SuggestQueryDTO suggest) {
		this.suggest = suggest;
	}

	public List<RegexpDTO> getRegexp() {
		return regexp;
	}

	public void setRegexp(List<RegexpDTO> regexp) {
		this.regexp = regexp;
	}

	public String getDataType() {
		return dataType;
	}

	@Override
	public void setDataType(String type) {
		dataType = type;
	}

	public Set<String> getFieldsExcludedOnQuery() {
		return fieldsExcludedOnQuery;
	}

	@Override
	public void setFieldsExcludedOnQuery(Set<String> fieldsExcludedOnQuery) {
		this.fieldsExcludedOnQuery = fieldsExcludedOnQuery;
	}

	public String[] getDefaultSearchFields() {
		return defaultSearchFields;
	}

	public void setDefaultSearchFields(String[] defaultSearchFields) {
		this.defaultSearchFields = defaultSearchFields;
	}

	public String[] getDefaultHighlightFields() {
		return defaultHighlightFields;
	}

	public void setDefaultHighlightFields(String[] defaultHighlightFields) {
		this.defaultHighlightFields = defaultHighlightFields;
	}

	public String[] getDefaultSuggestFields() {
		return defaultSuggestFields;
	}

	public void setDefaultSuggestFields(String[] defaultSuggestFields) {
		this.defaultSuggestFields = defaultSuggestFields;
	}

	@Override
	public void createSimpleQueryDTOFromSuggestQueryParams(String[] fields, String text, Integer size) {

		SuggestQueryDTO suggestQueryDTO = new SuggestQueryDTO();

		suggestQueryDTO.setText(text);
		if (fields != null && fields.length > 0) {
			suggestQueryDTO.setSearchFields(fields);
		} else if (defaultSuggestFields != null) {
			suggestQueryDTO.setSearchFields(defaultSuggestFields);
		}
		if (size != null) {
			suggestQueryDTO.setSize(size);
		}
		this.setSuggest(suggestQueryDTO);
	}

	@Override
	public void createSimpleQueryDTOFromTextQueryParams(String[] fields, String text, Integer from, Integer size) {

		if (text != null) {
			TextQueryDTO textDTO = new TextQueryDTO();
			textDTO.setText(text);

			if (fields != null && fields.length > 0) {
				textDTO.setHighlightFields(fields);
			} else if (defaultSearchFields != null) {
				textDTO.setSearchFields(defaultSearchFields);
			}

			if (defaultHighlightFields != null) {
				textDTO.setHighlightFields(getDefaultHighlightFields());
			}

			this.setText(textDTO);
		}
		if (from != null) {
			this.setFrom(from);
		}
		if (size != null) {
			this.setSize(size);
		}
	}

	@Override
	public void checkFieldsExcludedOnQuery() {

		for (String fieldName : fieldsExcludedOnQuery) {

			Field field = getFieldFromClass(this.getClass(), fieldName);
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new DTONotValidException(new BindException(this, fieldName));
			}
			if (value != null)
				throw new DTONotValidException(new BindException(this, fieldName));
		}
	}

	@JsonIgnore
	private Field getFieldFromClass(Class<?> queryClass, String fieldName) {

		try {
			return queryClass.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			return getFieldFromClass(queryClass.getSuperclass(), fieldName);
		}
	}

	@Override
	public void addAccessibilityIds(List<Long> accessibilities) {
		// Se descarta la implementación por no ser necesaria a este nivel
	}

	@Override
	public void setFixedQuery(Map<String, Object> fixedQuery) {
		getTerms().putAll(fixedQuery);
	}
}