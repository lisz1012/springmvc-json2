package com.lisz.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 由org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver处理的
@ResponseStatus(reason = "名字错误", value = HttpStatus.BAD_REQUEST)
public class UsernameException extends RuntimeException {
}
