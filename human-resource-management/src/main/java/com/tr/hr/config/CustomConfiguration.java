package com.tr.hr.config;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tr.hr.handler.HrResponseErrorHandler;
import com.tr.hr.interceptors.HrClientHttpRequestResponseInterceptor;
import com.tr.hr.resolver.RequestLocaleResolver;

@Configuration
public class CustomConfiguration {

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

	@Bean
	public RestTemplate defaultRestTemplate() {
		RestTemplate defaultRestTemplate = new RestTemplate();
		defaultRestTemplate.setErrorHandler(hrResponseErrorHandler());
		defaultRestTemplate.setInterceptors(Arrays.asList(hrClientHttpRequestInterceptor()));
		return defaultRestTemplate;
	}

	@Bean()
	public HrClientHttpRequestResponseInterceptor hrClientHttpRequestInterceptor() {
		HrClientHttpRequestResponseInterceptor hrClientHttpRequestInterceptor = new HrClientHttpRequestResponseInterceptor();
		return hrClientHttpRequestInterceptor;
	}

	@Bean()
	public HrResponseErrorHandler hrResponseErrorHandler() {
		HrResponseErrorHandler hrResponseErrorHandler = new HrResponseErrorHandler();
		return hrResponseErrorHandler;
	}

}
