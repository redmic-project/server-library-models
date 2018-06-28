package es.redmic.models.es.common.dto;

public class ErrorDTO extends SuperDTO {

	private ErrorTypeDTO error;

	public ErrorDTO(String description, String code) {
		super(false);
		this.error = new ErrorTypeDTO();
		this.error.setDescription(description);
		this.error.setCode(code);
	}

	public ErrorTypeDTO getError() {
		return error;
	}

	public void setError(ErrorTypeDTO error) {
		this.error = error;
	}
}