package com.mingi.aspectj.combinedpointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mingi.aspectj.combinedpointcut.config.AppConfig;
import com.mingi.aspectj.combinedpointcut.dao.MyDao;
import com.mingi.aspectj.combinedpointcut.service.MyService;
import com.mingi.aspectj.combinedpointcut.web.WebController;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		*/
		WebController webController = (WebController) context.getBean("webController"/*, WebController.class*/);
		MyService myService = context.getBean("myService", MyService.class);
		MyDao myDao = context.getBean("myDao", MyDao.class);
		
		System.out.println("------------------------------------------------------------------------");
		webController.handleRequest();
		
		System.out.println("------------------------------------------------------------------------");
		myService.performBusinessLogic();
		
		System.out.println("------------------------------------------------------------------------");
		myDao.accessData();

	}

}
