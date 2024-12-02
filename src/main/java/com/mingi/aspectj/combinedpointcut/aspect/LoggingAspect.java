package com.mingi.aspectj.combinedpointcut.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("com.mingi.aspectj.combinedpointcut.pointcut.CommonPointcuts.inWebLayer()"
			+ "&& execution(public * *(..))")
	public void publicWebLayerOperation() {}
	
	@Pointcut("com.mingi.aspectj.combinedpointcut.pointcut.CommonPointcuts.businessService()"
			+ "&& !com.mingi.aspectj.combinedpointcut.pointcut.CommonPointcuts.inDataAccessLayer()")
	public void transactionServiceOperation() {}
	
	@Pointcut("publicWebLayerOperation() || transactionServiceOperation()")
	public void webOrTransactionalServiceOperation() { }
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Before("publicWebLayerOperation()")
	public void LogBeforePublicWebOperation(JoinPoint joinPoint) {
		System.out.println("LogBeforePublicWebOperation 어드바이스");
		System.out.println("Method: " + joinPoint.getSignature().getName());
	}
	
	// 코드 상 겹치는 부분이 없기 때문에 동작하지 않는게 정상이다.
	@Before("transactionServiceOperation()")
	public void LogBeforePublicTransactionaloOperation(JoinPoint joinPoint) {
		System.out.println("LogBeforePublicTransactionalOperation 어드바이스");
		System.out.println("Method: " + joinPoint.getSignature().getName());
	}
	
	@Before("webOrTransactionalServiceOperation()")
	public void LogBeforWebOrTransactionaloOperation(JoinPoint joinPoint) {
		System.out.println("LogBeforeWebOrTransactionalOperation 어드바이스");
		System.out.println("Target class: " + joinPoint.getTarget().getClass().getName());
		System.out.println("Method: " + joinPoint.getSignature().getName());
	}
}
