package com.tr.hr.common;

public class ErrorField {

	private String code;
	
	private String message;
	
	public ErrorField() {
		// TODO Auto-generated constructor stub
	}

	public ErrorField(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
