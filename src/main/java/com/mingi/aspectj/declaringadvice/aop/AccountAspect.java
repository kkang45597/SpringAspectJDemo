package com.mingi.aspectj.declaringadvice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

	@Around("execution(java.util.List<com.mingi.aspectj.declaringadvice.model.Account> " +
			"com.mingi.aspectj.declaringadvice.service.AccountService.find*(..)) " + 
			"&& com.mingi.aspectj.declaringadvice.aspect.CommonPointcuts.inDataAccessLayer() " +
			"&& args(accountHolderNamePattern)")
	
	public Object preProcessingQuerryPatern(ProceedingJoinPoint pj,
			String accountHolderNamePattern) throws Throwable {
		
		System.out.println("preProcessingQuerryPatern Advice");
		System.out.println("Class: " + pj.getTarget().getClass().getName());
		System.out.println("Method: " + pj.getSignature().getName());
		System.out.println("------------------------------------------------------------------------");
		
//		Object ret = pj.proceed();
//		return ret;
		
		String newPattern = preProcess(accountHolderNamePattern);
		return pj.proceed(new Object[] { newPattern });
	}

	private String preProcess(String pattern) {
		return pattern.toUpperCase();
	}
}
