package com.KSTech.learnmicroserviceswithspringboot;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class LearnMicroServicesWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMicroServicesWithSpringBootApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		// Instead of session locale resolver we should be use the Acceptheaderresolver
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	// This is what from where application refer the localised content as of now, we have focused onto the static content
	// We can put it application.properties file
   /*
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}*/
}
