package com.tr.hr.config;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tr.hr.resolver.RequestLocaleResolver;

@Configuration
public class CustomConfiguration  {

	@Bean(initMethod = "initialize")
	public LocaleResolver localeResolver() {
		LocaleResolver customLocaleResolver = new RequestLocaleResolver();
		return customLocaleResolver;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:i18n/messages");
		messageSource.setDefaultLocale(Locale.forLanguageTag("tr"));
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.toString());
		return messageSource;

	}

}
