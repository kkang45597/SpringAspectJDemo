package com.mingi.aspectj.declaringadvice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.mingi.aspectj.declaringadvice.service.*.* (..))")
	public void logBeforeMethod(JoinPoint jp) { 
		System.out.println("logBeforeMethod Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("------------------------------------------------------------------------");
	}
	
	@AfterReturning(
			pointcut = "execution(* com.mingi.aspectj.declaringadvice.service.*.* (..))",
			returning = "result"
			)
	public void logAfterReturnong(JoinPoint jp, Object result) {
		System.out.println("logAfterReturing Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("Method return: " + result);
		System.out.println("------------------------------------------------------------------------");
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.mingi.aspectj.declaringadvice.service.*.* (..))",
			throwing = "error"
			)
	public void logAfterThrowing(JoinPoint jp, Throwable error) {
		System.out.println("logAfterThrowing Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("Method throw execption: " + error);
		System.out.println("------------------------------------------------------------------------");
	}
	
	@After("execution(* com.mingi.aspectj.declaringadvice.service.*.* (..))")
	public void logAfterFinally(JoinPoint jp) {
		System.out.println("logAfterFinally Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("------------------------------------------------------------------------");
	}
}
