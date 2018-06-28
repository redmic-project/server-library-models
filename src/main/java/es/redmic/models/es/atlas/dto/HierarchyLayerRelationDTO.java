package es.redmic.models.es.atlas.dto;

public class HierarchyLayerRelationDTO {

	private Long id;

	private Long parentId;
	
	public HierarchyLayerRelationDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	
}