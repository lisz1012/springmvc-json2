package com.lisz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@RequestMapping("/exception1")
	public String testException(){
		System.out.println(getClass().getName());
		int i = 10/0;
		return "success";
	}

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handlerException(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exce", e);
		return mav;
	}
}
