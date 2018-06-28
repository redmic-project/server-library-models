package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.DTOImplementWithMeta;

public class DocumentCompactDTO extends DTOImplementWithMeta {

	@NotNull
	@Size(min = 1, max = 500)
	protected String title;

	@NotNull
	@Size(min = 1, max = 1000)
	protected String author;

	@NotNull
	protected Integer year;

	@Size(min = 0, max = 250)
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
