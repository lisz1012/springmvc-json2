package com.lisz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

	@RequestMapping("/testInterceptor")
	public String testInterceptor(){
		//int i = 1/0;
		System.out.println(getClass().getName());
		return "success";
	}
}
