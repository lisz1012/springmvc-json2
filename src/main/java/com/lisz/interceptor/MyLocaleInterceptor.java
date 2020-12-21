package com.lisz.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleInterceptor implements HandlerInterceptor {
	@Autowired
	@Qualifier("localeResolver")
	private SessionLocaleResolver sessionLocaleResolver;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Locale locale = null;
		String localeName = request.getParameter("locale");
		if (!StringUtils.isBlank(localeName)) {
			String strs[] = localeName.split("_");
			if (strs.length != 2) {
				throw new IllegalArgumentException("Locale param is illegal");
			}
			locale = new Locale(strs[0], strs[1]);
			System.out.println("LOcale: " + locale);
			if (sessionLocaleResolver != null) {
				sessionLocaleResolver.setLocale(request, response, locale);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
