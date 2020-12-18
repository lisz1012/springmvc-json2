package com.lisz.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntityController {

	@RequestMapping("/test")
	public String test(HttpEntity<String> httpEntity) {
		System.out.println(httpEntity);
		System.out.println("Header: " + httpEntity.getHeaders());
		System.out.println("Body: " + httpEntity.getBody());
		return "success";
	}


	@RequestMapping("/testResponseEntity")
	public ResponseEntity<String> testResponseEntity(){
		String str = "<h1>Hello Spring MVC</h1>";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Set-COokie", "name=zhangsan");
		return new ResponseEntity<String>(str, headers, HttpStatus.OK);
	}
}
