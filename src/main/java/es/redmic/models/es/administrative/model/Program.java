package es.redmic.models.es.administrative.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Program extends ActivityBase {

	public Program() {
		super();
	}
}