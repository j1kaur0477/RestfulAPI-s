package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootHibernateSqlcrudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateSqlcrudRestApplication.class, args);
	}
	
	//bean to resolve locale(orgin of request)
	//if language is not specified - it will use default US Language
	@Bean
	public LocaleResolver localeResolver() {
		//if using request header
		//SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
		
		//else
		AcceptHeaderLocaleResolver sessionLocaleResolver=new AcceptHeaderLocaleResolver();

		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	//it is used to resolve text messages - base name is used to search for location of text messages
	//this configuration can be done in application.proeprties file
	
	//@Bean 
	//	public ResourceBundleMessageSource bundleMessageSource() {
	//		ResourceBundleMessageSource resourceBundleMessageSource=new ResourceBundleMessageSource();
	//		resourceBundleMessageSource.setBasename("messages");
	//		return resourceBundleMessageSource;
	//		
	//	}

}
