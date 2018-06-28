package es.redmic.models.es.administrative.taxonomy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Species extends Taxon {

	private String image;

	private String groupIcon;

	private Peculiarity peculiarity;

	public Species() {
		super();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGroupIcon() {
		return groupIcon;
	}

	public void setGroupIcon(String groupicon) {
		this.groupIcon = groupicon;
	}

	public Peculiarity getPeculiarity() {
		return peculiarity;
	}

	public void setPeculiarity(Peculiarity peculiarity) {
		this.peculiarity = peculiarity;
	}
}