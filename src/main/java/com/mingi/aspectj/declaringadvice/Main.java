package com.mingi.aspectj.declaringadvice;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mingi.aspectj.declaringadvice.aop.ExecutionCountingAspect;
import com.mingi.aspectj.declaringadvice.config.AppConfig;
import com.mingi.aspectj.declaringadvice.dao.AccountDao;
import com.mingi.aspectj.declaringadvice.model.Account;
import com.mingi.aspectj.declaringadvice.model.MyType;
import com.mingi.aspectj.declaringadvice.service.AccountService;
import com.mingi.aspectj.declaringadvice.service.MyService;
import com.mingi.aspectj.declaringadvice.service.SampleService;

public class Main {
	
	public static void CheckAroundAdviceThroughAccountAccountService(ApplicationContext context) {
		
//		AccountDao dao = context.getBean(AccountDao.class);
//		AccountService accountService = context.getBean(AccountService.class);
//		
//		Account validAccount = new Account();
//		validAccount.setId("12345");
//		validAccount.setOwnerName("Mingi Kim");
//		validAccount.setBalance(1000.0);
//		
//		accountService.updateAccount(validAccount);
//		
//		List<Account> account1 = accountService.findAccounts("hello world");
//		List<Account> account2 = accountService.findAccountName(validAccount);
//		
//		MyService myService = (MyService) context.getBean("myService");
//		myService.performTask();
//		
//		myService.helloworld("you"); // 240902 잘안됨 (보류)
	}
	
	public static void CheckAroundAdviceThroughAccountAccountService2(ApplicationContext context) {
		
//		AccountDao dao = context.getBean(AccountDao.class);
//		AccountService accountService = context.getBean(AccountService.class);
//		
//		Account validAccount = new Account();
//		validAccount.setId("12345");
//		validAccount.setOwnerName("Mingi Kim");
//		validAccount.setBalance(1000.0);
//		
//		accountService.updateAccount(validAccount);
//		
//		validAccount.setBalance(-5000.0); // 오류 유발용
//		try { 
//			accountService.updateAccount(validAccount);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		List<Account> account1 = accountService.findAccounts("hello world");
//		List<Account> account2 = accountService.findAccountName(validAccount);
	}
	
	public static void adviceParametersAndGenerics(ApplicationContext context) {
//		SampleService sampleService = (SampleService) context.getBean("sampleService");
//		
//		MyType myTypeInstance = new MyType("ExampleName");
//		sampleService.sampleGenericMethod(myTypeInstance);
//		sampleService.sampleGenericCollection(Arrays.asList(myTypeInstance));
	}
	
	public static void checkAutomicThreadSafe(ApplicationContext context) {
//		MyService myService = context.getBean(MyService.class);
//		
//		Runnable task = () -> myService.performTask("hello");
//		
//		Thread thraed1 = new Thread(task);
//		Thread thraed2 = new Thread(task);
//		Thread thraed3 = new Thread(task);
//		Thread thraed4 = new Thread(task);
//		Thread thraed5 = new Thread(task);
//		
//		try {
//			thraed1.join();
//			thraed2.join();
//			thraed3.join();
//			thraed4.join();
//			thraed5.join();
//		}
//		catch (InterruptedException e){
//			e.printStackTrace();
//		}
//		ExecutionCountingAspect countingAspect = context.getBean(ExecutionCountingAspect.class);
//		System.out.println("Total execution count: " + countingAspect.getExecutionCount());
	}
	
//	public static void 
	

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
//		CheckAroundAdviceThroughAccountAccountService(context);
//		CheckAroundAdviceThroughAccountAccountService2(context);
//		adviceParametersAndGenerics(context);
		
	}
}
