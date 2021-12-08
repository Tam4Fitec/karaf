package com.leguide.backoffice.karaf.services.email.models;

/**
 * Email attachment definition
 * 
 * @author Manuel Darcemont
 * 
 */
public class EmailAttachment {

	private Object file;

	private String fileName;

	private String contentType;

	public EmailAttachment(Object file, String fileName, String contentType) {
		super();
		this.file = file;
		this.fileName = fileName;
		this.contentType = contentType;
	}

	public Object getFile() {
		return file;
	}

	public void setFile(Object file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
