package com.tr.hr.common;

import java.io.Serializable;

import com.tr.hr.common.enums.ServiceResultType;

public class ServiceResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T data;

	private ServiceResultType resultType;

	private ErrorDetails error;


	public ServiceResult() {

	}
	
	public ServiceResult(ServiceResultType resultType) {
		setResultType(resultType);
	}
	
	public ServiceResult(T data, ServiceResultType resultType) {
		this(resultType);
		setData(data);
	}

	public ServiceResult(ErrorDetails error, ServiceResultType resultType) {
		this(resultType);
		setError(error);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ServiceResultType getResultType() {
		return resultType;
	}

	public void setResultType(ServiceResultType resultType) {
		this.resultType = resultType;
	}

	public ErrorDetails getError() {
		return error;
	}

	public void setError(ErrorDetails error) {
		this.error = error;
	}

}
