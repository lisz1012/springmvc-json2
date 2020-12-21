package com.lisz.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
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

	// 不用 MyLocaleInterceptor 配合SessionLocaleResolver的时候这么写
	// 所以此时在springmvc.xml文件中要暂时注释掉 <bean class="com.lisz.interceptor.MyLocaleInterceptor" />
	// 但是还是要在springmvc.xml里面配置org.springframework.web.servlet.i18n.SessionLocaleResolver这个bean
//	@GetMapping("/i18n")
//	public String i18n(@RequestParam(value = "locale", required = false) String localeName,
//			Locale locale, HttpSession session){
//		System.out.println("Locale: " + locale);
//		if (!StringUtils.isBlank(localeName)) {
//			String strs[] = localeName.split("_");
//			if (strs.length != 2) {
//				throw new IllegalArgumentException("Locale param is illegal");
//			}
//			locale = new Locale(strs[0], strs[1]);
//		}
//		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
//		return "login";
//	}
}
