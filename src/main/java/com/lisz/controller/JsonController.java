package com.lisz.controller;

import com.lisz.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ResponseBody 表示把当前请求返回的内容直接作为响应体，用来接受
 */
@Controller
public class JsonController {

	@ResponseBody
	@GetMapping("/json")
	public List<User> testJson01(){
		System.out.println("hahah");
		List<User> list = new ArrayList<>();
		list.add(new User(1, "n1", "male", 12));
		list.add(new User(2, "n2", "male", 12));
		list.add(new User(3, "n3", "female", 11));
		list.add(new User(4, "n4", "male", 13));
		return list;
	}

	@ResponseBody
	@RequestMapping("/json2")
	public String testJson02(){
		return "<h1>Hello, JSON</h1>";
	}

	@PostMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String body){
		System.out.println(body);
		return "success";
	}

	@PostMapping("/testRequestBody2")
	// 注意⚠️：前端如果就是一个普通的form发送各个属性，要想让spring mvc 自动组装User对象，则不要在User参数前面加@RequestBody
	public String testRequestBody2(User user){
		System.out.println(user);
		return "success";
	}

	@PostMapping("/testRequestJson")
	// 注意⚠️：前端如果发送JSON字符串，则要加上这个@RequestBody，来转换成User对象
	public String testRequestJson(@RequestBody User user){
		System.out.println(user);
		return "success";
	}
}
