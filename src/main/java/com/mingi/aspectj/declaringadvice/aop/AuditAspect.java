package com.mingi.aspectj.declaringadvice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mingi.aspectj.declaringadvice.annotation.Auditable;

@Aspect
@Component
public class AuditAspect {
	
	// @within: 특정 어노테이션이 클래스 레벨에서 적용될때, 해당 클레스의 모든 메서드에 매칭
	// 프록시 객체가 위암하는 실제 객체 (타겟 객체)에 어노테이션을 적용한 경우에 어드바이스가 실행
	@Pointcut("@within(com.mingi.aspectj.declaringadvice.annotation.Auditable)")
	public void withinAuditableClasss() { }
	
	
	// @target: 특정 어노테이션이 적용된 객체의 모든 메서드에 매칭, 이 포인트컷은 런타임 시점에, 프록시 객체가 생성될 때
	// 해당 객체의 클래스가 @Auditable 어노테이션을 가지고 있는지 확인. 만약 그렇다면, 해당 객체의 모든 메서드가 포인트컷에 매칭
	// 객체가 아닌 클래스 자체에 대한 어노테이션 기준으로 어드바이스를 적용한다.
	@Pointcut("@target(com.mingi.aspectj.declaringadvice.annotation.Auditable)")
	public void targetAuditableClass() { }
	
	// @annotation: 특정 어노테이션이 적용된 메서드라는 점
	@Pointcut("@annotation(auditable)")
	public void methodWithAuditableAnnotation(Auditable auditable) { }
	
	@Pointcut("execution(* com.mingi.aspectj.declaringadvice.service.*.* (..)) " + 
			"&& @args(com.mingi.aspectj.declaringadvice.annotation.Auditable)")
	public void methodWithAuditableArgs() { }
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	@Before("withinAuditableClasss()")
	public void logwithinAuditableClass(JoinPoint jp) {
		System.out.println("logwithinAuditableClass Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("------------------------------------------------------------------------");
	}
	
	@Before("targetAuditableClass()")
	public void logwtargetAuditableClass(JoinPoint jp) {
		System.out.println("logwtargetAuditableClass Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("------------------------------------------------------------------------");
	}
	
	
	@Before("methodWithAuditableAnnotation(auditable)")
	public void logAudiOperation(JoinPoint jp, Auditable auditable) {
		System.out.println("logAudiOperation Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("Operation:" + auditable.value());
		System.out.println("------------------------------------------------------------------------");
	}
	*/
	
	@Before("methodWithAuditableArgs()")
	public void logMethodWithAuditableArgs(JoinPoint jp) {
		System.out.println("logMethodWithAuditableArgs Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("------------------------------------------------------------------------");
	}
}
