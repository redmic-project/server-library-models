package es.redmic.models.es.common.dto;

import javax.validation.constraints.NotNull;

public abstract class CompactDTOImpl extends DTOImplementWithMeta {

	private Long id;
	
	@NotNull
	protected String name;

	public CompactDTOImpl() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
