package es.redmic.models.es.atlas;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.geotools.data.ows.StyleImpl;
import org.opengis.util.InternationalString;

import com.fasterxml.jackson.annotation.JsonSetter;

public class StyleLayer {

	private String name;
	private String title;
	private String abstractStyle;
	private String format;
	private String url;

	public StyleLayer() {
	}

	public StyleLayer(StyleImpl style) {
		setName(style.getName());
		setTitle(style.getAbstract());
		setabstractStyle(style.getAbstract());
		if (style.getLegendURLs() != null && style.getLegendURLs().size() > 0)
			setUrl(style.getLegendURLs().get(0).toString());

		if (getUrl() != null)
			setFormat(getUrl().replaceAll(".*&format=(\\w*)%2F(\\w*)&.*", "$1/$2"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	@JsonSetter("title")
	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(InternationalString title) {
		if (title != null)
			this.title = title.toString();
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getabstractStyle() {
		return abstractStyle;
	}

	@JsonSetter("abstractStyle")
	public void setabstractStyle(String abstractStyle) {
		this.abstractStyle = abstractStyle;
	}

	public void setabstractStyle(InternationalString abstractStyle) {
		if (abstractStyle != null)
			this.abstractStyle = abstractStyle.toString();
	}

	public String toString() {
		return "Name: " + getName() + ", Title: " + getTitle() + ", Abstract: " + getabstractStyle() + ", URL: "
				+ getUrl();
	}
}
