package com.example.demo.controller;

import java.util.Locale;

import org.apache.logging.log4j.message.Message;
import org.apache.tomcat.util.buf.MessageBytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("international")
public class InternationalisationController {

	//to resolve text messages using properties files
	//for resolving messages, with support for the parameterization and internationalization of the messages
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/lang")
	//1st way- get value of locale from request headers
	//public String checkInternationalisationOfRestAPI(@RequestHeader(name="Accept-Language",required = false) Locale locale) {
	
	//2nd way -get value from LocaleContextHolder
	public String checkInternationalisationOfRestAPI() {
	return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	//return "good.morning.message";

	}
	
}
