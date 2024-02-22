package com.sample.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAdvice {
	
	// pointcut 의미 : 반환타입 상관없고 com.sample.service 패키지의 Any클래스의 Any 메소드
	@AfterThrowing(pointcut = "execution(* com.sample.service.*.*(..))", throwing = "ex")
	public void handleException(Exception ex) {
		System.out.println("예외가 발생하였습니다. 오류 메세지: " + ex.getMessage());
	}

}
