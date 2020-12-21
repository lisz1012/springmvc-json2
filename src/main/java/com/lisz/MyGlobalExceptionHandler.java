package com.lisz;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class MyGlobalExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handlerException(Exception e){
		System.out.println("Global --- exception 1");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exce", e);
		return mav;
	}

	// 优先走最精细的匹配
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException2(Exception e){
		System.out.println("Global --- exception 2");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exce", e);
		return mav;
	}
}
