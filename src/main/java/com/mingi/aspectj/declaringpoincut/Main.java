package com.mingi.aspectj.declaringpoincut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mingi.aspectj.declaringpoincut.aspect.LoggingAspect;
import com.mingi.aspectj.declaringpoincut.config.AppConfig;
import com.mingi.aspectj.declaringpoincut.service.SpecialService;
import com.mingi.aspectj.declaringpoincut.service.TransferService;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		/*
		*/
		AppConfig config = (AppConfig) context.getBean("appConfig");
		LoggingAspect logAspect = (LoggingAspect) context.getBean("loggingAspect");
		
		TransferService tranService = (TransferService) context.getBean("transferService");
		tranService.transfer("12345", 10000);
		tranService.checkBalance();
		
		SpecialService specialService  = (SpecialService) context.getBean("specialService");
		specialService.specialOperation("Hi");
		specialService.anotherSpecialOperation("Bye");
		
	}
}
