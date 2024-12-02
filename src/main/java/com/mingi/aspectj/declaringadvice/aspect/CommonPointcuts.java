package com.mingi.aspectj.declaringadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {

	@Pointcut("within(com.mingi.aspectj.declaringadvice.service..*)")
	public void inDataAccessLayer() {
		
	}
}
