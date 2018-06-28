package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.CompactDTOImpl;

public class KeywordDTO extends CompactDTOImpl {

	@NotNull
	@Size(min = 1, max = 50)
	private String alias;

	@NotNull
	@Size(min = 1, max = 50)
	private String keyworden;

	@NotNull
	@Size(min = 1, max = 50)
	private String keywordsp;

	public KeywordDTO() {
		super();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getKeyworden() {
		return keyworden;
	}

	public void setKeyworden(String keyworden) {
		this.keyworden = keyworden;
	}

	public String getKeywordsp() {
		return keywordsp;
	}

	public void setKeywordsp(String keywordsp) {
		this.keywordsp = keywordsp;
	}
}
