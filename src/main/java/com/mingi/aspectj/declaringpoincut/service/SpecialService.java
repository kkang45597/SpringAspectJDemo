package com.mingi.aspectj.declaringpoincut.service;

import com.mingi.aspectj.declaringpoincut.annotation.Loggable;
import com.mingi.aspectj.declaringpoincut.annotation.SpecialComponent;
import com.mingi.aspectj.declaringpoincut.annotation.Validated;

@SpecialComponent
public class SpecialService {
	
	@Loggable
	public void specialOperation(String operation) {
		System.out.println("Performing special operation: " + operation);
	}
	
	public void anotherSpecialOperation(@Validated String parameter) {
		System.out.println("Performing another special operation: " + parameter);
	}
}
