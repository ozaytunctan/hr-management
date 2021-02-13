package com.tr.hr.exceptions;

public class NotFoundEmployeeException extends RuntimeException {

	/**
	 * 
	 */
	
	private String messageKey;
	
	private Object []args;
	
	
	private static final long serialVersionUID = 1L;

	public NotFoundEmployeeException(String message) {
		super(message);
	}

	public NotFoundEmployeeException(String messageKey, Object[] args) {
		this.args=args;
		this.messageKey=messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	

}
