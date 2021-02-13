package com.tr.hr.common;

import java.util.List;

public class ErrorDetails {

	private String message;

	private List<ErrorField> fields;

	public ErrorDetails() {
	}

	public ErrorDetails(String message) {
		this.setMessage(message);
	}

	public ErrorDetails(String message, List<ErrorField> fields) {
		this(message);
		this.setFields(fields);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ErrorField> getFields() {
		return fields;
	}

	public void setFields(List<ErrorField> fields) {
		this.fields = fields;
	}

}
