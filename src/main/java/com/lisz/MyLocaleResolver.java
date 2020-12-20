package com.lisz;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 要想生效就要在springmvc.xml中配置：
 * <bean id="localeResolver" class="com.lisz.MyLocaleResolver" />
 */
public class MyLocaleResolver implements LocaleResolver {
	// 在postHandle和afterCompletion之间执行，想想也应该，就应该在渲染的时候替换某些文本
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Locale locale = null;
		String localeName = request.getParameter("locale");
		System.out.println("localeName: " + localeName);
		if (!StringUtils.isBlank(localeName)) {
			String strs[] = localeName.split("_");
			locale = new Locale(strs[0], strs[1]);
		} else {
			locale = request.getLocale();
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		throw new UnsupportedOperationException(
				"Cannot change HTTP accept header - use a different locale resolution strategy");
	}
}
