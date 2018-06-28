package es.redmic.models.es.maintenance.device.dto;

import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.CompactDTOImpl;

public class DeviceCompactDTO extends CompactDTOImpl {

	@Size(min = 0, max = 500)
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Size(min = 1, max = 500)
	@Override
	public String getName() {
		return name;
	}
}