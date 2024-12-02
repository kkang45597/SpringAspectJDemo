package com.mingi.aspectj.declaringadvice.service;

import org.springframework.stereotype.Service;

import com.mingi.aspectj.declaringadvice.annotation.Auditable;

@Service
public class MyService {
	
	public void performTask() {
		System.out.println("MyService 클래스의 performTask 메서드를 호출");
		System.out.println("------------------------------------------------------------------------");
		try {
			Thread.sleep(1000); // 지금부터 1초 동안 CPU를 사용하지 않겠다.
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void helloworld(@Auditable(value = "helloworld") String hello) {
		System.out.println("good-bye");
	}

}
