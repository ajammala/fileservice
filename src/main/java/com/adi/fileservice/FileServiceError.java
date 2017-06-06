package com.adi.fileservice;

/**
 * Class for customized error message for the api
 * @author aditya
 *
 */
public class FileServiceError {
	private String errorMessage;

	public FileServiceError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
