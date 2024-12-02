package com.mingi.aspectj.declaringadvice.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect("perThis(serviceMethods())")
public class LoggingAspectPerThis {

	private int executionCount = 0;
	
	@Pointcut("execution(* com.mingi.aspectj.declaringadvice.service.sampleService.*(..))")
	public void serviceMethods() { }
	
	@Before("serviceMehtods()")
	public void logExecution() {
		executionCount++;
		System.out.println("Method executed: " + executionCount + "times for this instance");
	}
}
