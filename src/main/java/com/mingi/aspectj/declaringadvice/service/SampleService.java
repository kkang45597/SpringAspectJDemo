package com.mingi.aspectj.declaringadvice.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.mingi.aspectj.declaringadvice.annotation.AuditCode;
import com.mingi.aspectj.declaringadvice.annotation.Auditable;
import com.mingi.aspectj.declaringadvice.model.MyType;

@Service
public class SampleService implements Sample<MyType> {

//	@Auditable(AuditCode.USER_ACTION)
//	public void sampleGenericMethod(String data) {
//		System.out.println("");
//		
//	}
	
	@Override
	public void sampleGenericMethod(MyType param) {
		// TODO Auto-generated method stub
		
	} 
	
	@Override
	public void sampleGenericCollection(Collection<MyType> param) {
		// TODO Auto-generated method stub
		
	}



}
