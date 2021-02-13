package com.tr.hr.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tr.hr.common.ServiceResult;
import com.tr.hr.exceptions.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { BusinessException.class })
	public ServiceResult<?> businessExceptionHandler() {
		return null;
	}

}
