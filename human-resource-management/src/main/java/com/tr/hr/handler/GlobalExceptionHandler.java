package com.tr.hr.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tr.hr.common.ErrorDetails;
import com.tr.hr.common.ServiceResult;
import com.tr.hr.common.enums.ServiceResultType;
import com.tr.hr.exceptions.BusinessException;
import com.tr.hr.exceptions.NotFoundEmployeeException;
import com.tr.hr.service.MessageService;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Autowired
	private MessageService messageService;
	
	
	@ExceptionHandler(value = { BusinessException.class })
	@ResponseBody
	public ServiceResult<?> businessExceptionHandler(BusinessException exception) {
		return null;
	}
	
	@ExceptionHandler(value = { NotFoundEmployeeException.class })
	@ResponseBody
	public ServiceResult<?> notFoundEmployeeExceptions(NotFoundEmployeeException ex) {
		String message = messageService.get(ex.getMessageKey(), ex.getArgs());
		ErrorDetails errorDetails = new ErrorDetails(message);
		return new ServiceResult<>(errorDetails,ServiceResultType.ERROR);
	}

}
