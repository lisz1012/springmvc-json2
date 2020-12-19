package com.lisz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** 配置上：
 * <mvc:interceptors>
 *         <bean class="com.lisz.interceptor.MyInterceptor" />
 *     </mvc:interceptors>
 * 执行顺序：
 *      preHandler ---> 目标Controller的方法 ---> postHandler ---> 先页面跳转 -----> afterCompletion
 *          如果执行过程中抛出异常，那么postHandler不糊执行，但是afterCompletion依然会继续执行
 */
public class MyInterceptor implements HandlerInterceptor {
	/**
	 * 在处理器处理具体的方法之前开始执行
	 * @param request
	 * @param response
	 * @param handler
	 * @return      注意返回值，如果返回值是false表示请求处理到此为止，如果是true，才会接着向下执行. 这里如果早早返回，
	 *              则并不会执行任何Interceptor的postHandle，所有的pre/postHandle方法是在 HandlerExecutionChain
	 *              里面先正序然后又倒序执行了一遍（中间执行了Controller的方法）
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(getClass().getName() + "---------------preHandler");
		return true; // false 就不会接着往下走了，Controller不会被调用
	}

	/**
	 * 在处理器完成方法的处理之后执行
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println(getClass().getName() + "---------------postHandler");
	}

	/**
	 * 整个servlet处理完成之后才会执行，主要做资源清理的工作
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println(getClass().getName() + "---------------afterCompletion");
	}
}
