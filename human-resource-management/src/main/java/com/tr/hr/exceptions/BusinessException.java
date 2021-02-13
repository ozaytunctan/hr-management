package com.tr.hr.exceptions;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	private String messageKey;

	public BusinessException(String messageKey) {
		super(messageKey);
		this.setMessageKey(messageKey);
	}

	public BusinessException(String message, String messageKey) {
		this(messageKey);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
}
