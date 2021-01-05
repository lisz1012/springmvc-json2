package com.lisz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@Controller
@SessionAttributes
public class SourceCodeTestController {
	@RequestMapping("/test2")
	public void test2(@SessionAttribute String username){

	}

	@RequestMapping("/test3")
	public String test3(@RequestParam("username") String username, String password, Map<String, Object> map){
		System.out.println(username);
		System.out.println(password);
		return "success";
	}
}
