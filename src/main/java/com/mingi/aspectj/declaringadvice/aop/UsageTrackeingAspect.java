package com.mingi.aspectj.declaringadvice.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.mingi.aspectj.declaringadvice.model.DefaultUsageTracked;
import com.mingi.aspectj.declaringadvice.model.UsageTracked;

@Aspect
@Component
public class UsageTrackeingAspect {

	@DeclareParents(value="com.mingi.aspectj.declaringadvice.service.* + ",
			defaultImpl = DefaultUsageTracked.class)
	public static UsageTracked mixin;

	@Before("execution (* com.mingi.aspectj.declaringadvice.service.*.*(..))) "
			+ "&& this(usageTracked)")
	public void trackUsage(UsageTracked usageTracked) {
		usageTracked.incrementUseCount();
		System.out.println("Usage count incremented: " + usageTracked.getUseCount());
		
	}
}
