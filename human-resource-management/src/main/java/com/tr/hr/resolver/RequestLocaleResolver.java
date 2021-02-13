package com.tr.hr.resolver;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;

public class RequestLocaleResolver implements LocaleResolver{
	
	@Value("#{'${application.internationalization.allowed.languages}'.split(',')}")
	private List<String> supportedLanguages;

	@Value("${application.internationalization.default.language}")
	private String defaultLanguage ;
	
	
	public void initialize() {
		LocaleContextHolder.setLocale(Locale.forLanguageTag(defaultLanguage));
	}

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String acceptLanguage = request.getHeader("Accept-Language");
		if (!supportedLanguages.contains(acceptLanguage))
			acceptLanguage = defaultLanguage;

		return Locale.forLanguageTag(acceptLanguage);
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		LocaleContextHolder.setLocale(resolveLocale(request));
	}

}
