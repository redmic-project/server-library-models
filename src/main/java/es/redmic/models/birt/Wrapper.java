package es.redmic.models.birt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Wrapper {

	public Wrapper() {
	}
}