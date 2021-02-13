package com.tr.hr.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.tr.hr.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageSource messageSource;

	@Override
	public String get(String key) {
		return get(key, null);
	}

	@Override
	public String get(String key, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		String message = this.messageSource.getMessage(key, args, locale);
		return message;
	}

}
