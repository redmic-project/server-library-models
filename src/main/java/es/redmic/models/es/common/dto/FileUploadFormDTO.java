package es.redmic.models.es.common.dto;

import org.springframework.web.multipart.MultipartFile;


public class FileUploadFormDTO {
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
