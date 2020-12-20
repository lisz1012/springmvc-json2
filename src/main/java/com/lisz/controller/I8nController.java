package com.lisz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class I8nController {
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/i18n")
	public String i18n(Locale locale){
		System.out.println(locale);
		String username = messageSource.getMessage("username", null, locale);
		System.out.println(username);
		return "login";
	}
}
