package com.tr.hr.common;

public class ErrorField {

	private String name;
	
	private String message;
	
	public ErrorField() {
		// TODO Auto-generated constructor stub
	}

	public ErrorField(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
