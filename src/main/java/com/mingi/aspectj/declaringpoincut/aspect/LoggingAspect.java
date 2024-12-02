package com.mingi.aspectj.declaringpoincut.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component // 이 어노테이션이 적용된 클래스는 스프링 IoC에 의해 객체로 만들어져 빈으로 등록된다.
public class LoggingAspect {

	/*
	// 특정 (transfer) 메서드 이름을 매칭하는 포인트컷
	@Pointcut("execution(* transfer(..))")
	public void anyTransferOperation() { }
	
	// TransferService 클래스내의 모든 메서드를 매칭하는 포인트컷
	@Pointcut("within(com.mingi.aspectj.declaringpoincut.service.TransferService)")
	private void withinTransferService() { }
	
	// this PCD를 사용하여 프록시 객체의 타입에 따라 매칭
	@Pointcut("this(com.mingi.aspectj.declaringpoincut.service.TransferService)")
	private void proxyIsTransferService() { }
	
	// target PCD를 사용하여 실제 타겟 객체의 타입에 따라 매칭
	@Pointcut("target(com.mingi.aspectj.declaringpoincut.service.SpecialService)")
	private void targetIsSpecialrService() { }
	
	// args 디지그네이터를 사용하여 메서드의 아규먼트가 특정 타입인 경우 매칭
	@Pointcut("args(String, ..)")
	private void methodWithStringArg() { }
	
	// @annotation 디지그네이터를 사용하여 메서드에 특정 어노테이션이 있는 경우 매칭
	@Pointcut("@annotation(com.mingi.aspectj.declaringpoincut.annotation.Loggable)")
	private void loggableMethods() { }
	
	// @within 디지그네이터를 사용하여 클래스에 특정 어노테이션이 있는 경우 매칭
	@Pointcut("@within(com.mingi.aspectj.declaringpoincut.annotation.SpecialComponent)")
	private void withinSpecialComponent() { }
	
	// @target 디지그네이터를 사용하여 실제 객체가 특정 어노테이션을 가지고 있는 경우에 매칭
	@Pointcut("@target(com.mingi.aspectj.declaringpoincut.annotation.SpecialComponent)")
	private void targetHasSpecialComponent() { }
	
	*/
	// @args 디지그네이터를 사용하여 메서드의 아규먼트(파라미터)가 특정 어노테이션을 가진 타입일 경우 매칭
	@Pointcut("@args(com.mingi.aspectj.declaringpoincut.annotation.Validated)")
	private void methodWithValidatedArgs() { }
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	@Before("anyTransferOperation()") // value 값으로 어드바이스가 와야 한다.
	public void logBeforeTransfer() {
		System.out.println("logBeforeTransfer 메서드 호출");
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	
	@Before("withinTransferService()")
	public void logBeforeWithinTransferService(JoinPoint joinPoint) {
		Object proxy = joinPoint.getThis();
		System.out.println("logBeforeWithinTransferService");
		System.out.println("Proxy class: " + proxy.getClass().getName());
		System.out.println("Method: " + joinPoint.getSignature());
		System.out.println("Target object: " + joinPoint.getTarget());
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	
	@Before("proxyIsTransferService()")
	public void logWhenProxyIsTransferService(JoinPoint joinPoint){
		Object proxy = joinPoint.getThis();
		System.out.println("Logging when proxy is of type TransferService");
		System.out.println("Proxy class: " + proxy.getClass().getName());
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	
	@Before("targetIsSpecialrService()")
	public void logWhenTargetIsSpecialService(JoinPoint joinPoint){
		System.out.println("Logging when proxy is of type SpecialService");
		System.out.println("Target class: " + joinPoint.getClass().getName());
		System.out.println("Method being called: " + joinPoint.getSignature().getName());
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	
	@Before("methodWithStringArg()")
	public void logForMethodsWithStringArg(JoinPoint joinPoint) {
		System.out.println("Logging method with String argument");
		System.out.println("Method being called: " + joinPoint.getSignature().getName());
		System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	
	@Before("loggableMethods()")
	public void logForLoggableMethods(JoinPoint joinPoint) {
		System.out.println("Logging for method annotated with @Loggable");
		System.out.println("Method: " + joinPoint.getSignature().getName());
		System.out.println("Target class: " + joinPoint.getClass().getName());
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	// @SpecialComponent 어노테이션이 붙은 클래스 내의 메서드가 호출될때, 메서드와 클래스 이름을 로그로 출력
	@Before("withinSpecialComponent()")
	public void logwithinSpecialComponent(JoinPoint joinPoint) {
		System.out.println("Logging for method within @SpecialComponent class");
		System.out.println("Method: " + joinPoint.getSignature().getName());
		System.out.println("Class: " + joinPoint.getClass().getName());
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	
	@Before("targetHasSpecialComponent()")
	public void logtargetSpecialComponent(JoinPoint joinPoint) {
		System.out.println("Logging for targets annotated with @SpecialComponent class");
		System.out.println("Target class: " + joinPoint.getTarget().getClass().getName());
		System.out.println("Method: " + joinPoint.getSignature().getName());
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
	*/
	
	@Before("methodWithValidatedArgs()")
	public void logForMethodswithValidatedArgs(JoinPoint joinPoint) {
		System.out.println("Logging for methods with @Validated annotated arguments");
		System.out.println("Method: " + joinPoint.getSignature().getName());
		System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("-------------------------------------------------------------------"
				+ "----------------------------------");
	}
}
