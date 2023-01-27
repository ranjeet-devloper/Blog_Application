package com.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Long fieldvalue;

	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldvalue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}

	public ResourceNotFoundException() {
		super();
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Long getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(Long fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

}
