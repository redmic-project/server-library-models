package es.redmic.models.es.common.dto;

import javax.validation.constraints.NotNull;

public class ReportDTO implements DTOString {

	private String id; // == taskId

	private String titleDefinedByUser;

	@NotNull
	private String selectId;

	@NotNull
	private Long userId;

	@NotNull
	private String taskType;

	private String taskLabel;

	public ReportDTO() {

	}

	public String getTitleDefinedByUser() {
		return titleDefinedByUser;
	}

	public void setTitleDefinedByUser(String titleDefinedByUser) {
		this.titleDefinedByUser = titleDefinedByUser;
	}

	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}

	public Boolean isSelectionId() {
		// TODO: Si cambia la generación de ids de seleccionados en elastic,
		// cambiar esto.
		return selectId.contains("-");
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskLabel() {
		return taskLabel;
	}

	public void setTaskLabel(String taskLabel) {
		this.taskLabel = taskLabel;
	}
}
