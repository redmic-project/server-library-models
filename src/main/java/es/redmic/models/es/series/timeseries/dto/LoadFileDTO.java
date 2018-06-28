package es.redmic.models.es.series.timeseries.dto;

import es.redmic.models.es.common.request.dto.CSVBaseDTO;

public class LoadFileDTO extends CSVBaseDTO {
	
	Long dataDefinitionId;
	
	String fileName;

	public LoadFileDTO() {
	}

	public Long getDataDefinitionId() {
		return dataDefinitionId;
	}

	public void setDataDefinitionId(Long dataDefinitionId) {
		this.dataDefinitionId = dataDefinitionId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
