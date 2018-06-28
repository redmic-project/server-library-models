package es.redmic.models.es.common.request.dto;

public class CategoryPathInfo {
	
	private String path;
	
	private String nested;
	
	private String target;
	
	public CategoryPathInfo(String path, String target) {
	
		this.path = path;
		this.target = target;
	}
	
	public CategoryPathInfo(String path, String nested, String target) {
		
		this.path = path;
		this.nested = nested;
		this.target = target;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNested() {
		return nested;
	}

	public void setNested(String nested) {
		this.nested = nested;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}