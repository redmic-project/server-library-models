package es.redmic.models.es.common.model;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 11:55:18
 */
public abstract class BasePathAbstractES extends BaseAbstractES {

	private String path;

	public BasePathAbstractES() {
		super();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}