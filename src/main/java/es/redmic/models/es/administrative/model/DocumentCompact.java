package es.redmic.models.es.administrative.model;

import es.redmic.models.es.common.model.BaseAbstractES;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 11:55:18
 */
public class DocumentCompact extends BaseAbstractES {

	private String title;
	private String author;
	private String year;
	private String url;

	public DocumentCompact() {
		super();
	}

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
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}