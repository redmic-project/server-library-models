package es.redmic.models.es.administrative.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.constraintvalidate.language.ValidateLanguage;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.administrative.dto.DocumentTypeDTO;

public class DocumentDTO extends DocumentCompactDTO {

	@Size(min = 0, max = 20)
	private String code;

	@NotNull
	@Size(min = 1, max = 500)
	private String source;

	@NotNull
	@ValidateLanguage
	@Size(min = 2, max = 2)
	private String language;

	@Size(min = 0, max = 1500)
	private String remark;

	@Size(min = 0, max = 500)
	private Set<String> keyword;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.DOCUMENT_TYPE")
	private DocumentTypeDTO documentType;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getKeyword() {
		String keywords = null;
		if (keyword != null)
			keywords = StringUtils.collectionToCommaDelimitedString(keyword);

		return keywords;
	}

	public void setKeyword(String keyword) {
		HashSet<String> keywords = null;
		if (keyword != null && keyword.length() > 0) {
			String[] words = StringUtils.removeDuplicateStrings(keyword.split(","));
			keywords = new HashSet<String>();
			for (int i = 0; i < words.length; i++) {
				keywords.add(words[i].trim());
			}
		}
		this.keyword = keywords;
	}

	@JsonIgnore
	public Set<String> getKeywords() {
		return this.keyword;
	}

	@JsonIgnore
	public void setKeywords(Set<String> keyword) {
		this.keyword = keyword;
	}

	public DocumentTypeDTO getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeDTO documentType) {
		this.documentType = documentType;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public DateTime getInserted() {
		return inserted;
	}

	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
