package com.lisz.controller;

import com.lisz.interceptor.UsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 当使用ExceptionHandler进行处理的时候，默认会先走小范围，然后再寻找大范围
 * 当在某一个类中定义的ExceptionHandler只能处理当前类的异常信息，如果其他类包含的话，无法进行处理
 * 可以通过@ControllerAdvice注解进行标注，表示为全局异常处理类
 *
 * 每次进行异常处理的时候，现在Controller本类查找，然后去查找全局配置,@ControllerAdvice标注的类
 */
@Controller
public class ExceptionController {

	@RequestMapping("/exception1")
	public String testException(){
		System.out.println(getClass().getName());
		int i = 10/0;
		return "success";
	}
	/**
	 * @ResponseStatus虽然可以标注在方法上，但是不推荐使用! 返回200 OK也不会跳转到success.jsp页面
	 * @return
	 */
	@ResponseStatus(reason = "我就是错了，不知道啥原因", value = HttpStatus.OK)
	@RequestMapping("/exception2")
	public String testException2(){
		System.out.println("exception2");
		return "success";
	}

	@RequestMapping("/exception3")
	public String testException3(String username){
		if ("admin".equals(username)) {
			return "success";
		} else {
			throw new UsernameException();
		}
	}

	// org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver 来处理一些常见异常
	// 比如：会对不允许的方法：要求POST请求却发了个GET，进行默认的异常显示
	@RequestMapping(value = "/exception4", method = RequestMethod.POST)
	public String testException4(){
		System.out.println("exception4");
		return "success";
	}

//	@ExceptionHandler(ArithmeticException.class)
//	public ModelAndView handlerException(Exception e){
//	    System.out.println("exception 1");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("error");
//		mav.addObject("exce", e);
//		return mav;
//	}
//
//	// 优先走最精细的匹配
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handlerException2(Exception e){
//		System.out.println("exception 2");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("error");
//		mav.addObject("exce", e);
//		return mav;
//	}
}
