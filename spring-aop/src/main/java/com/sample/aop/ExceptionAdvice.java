package com.sample.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAdvice {
	
	@AfterThrowing(pointcut = "within(com.sample.service.*)", throwing = "ex")
	public void handleException(Exception ex) {
		System.out.println("예외가 발생하였습니다. 오류 메세지: " + ex.getMessage());
	}

}
