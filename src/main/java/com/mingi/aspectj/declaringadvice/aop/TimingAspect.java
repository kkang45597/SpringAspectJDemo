package com.mingi.aspectj.declaringadvice.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimingAspect {

	@Around("execution(* com.mingi.aspectj.declaringadvice.servuce.MyService.*(..))")
	public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		
		Date date = new Date(startTime);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:ss.SSS");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		
		System.out.println("Timer started for method: " + pjp.getSignature().getClass().getName());
		
		Object ret = pjp.proceed();
		
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		
		System.out.println("Timer stopped for method: " + pjp.getSignature().getName());
		System.out.println("Execution time : " + duration + " ms");
		
		return ret;
	}
}
