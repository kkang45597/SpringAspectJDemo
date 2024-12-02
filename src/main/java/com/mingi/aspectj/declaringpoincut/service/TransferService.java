package com.mingi.aspectj.declaringpoincut.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service 
// 어노테이션이 클래스 역활과 목적을 나타내는 메타데이터를 제공한다.
// 스트레오 타입: 개발자가 특정 클래스가 애플리케이션 내에서 어떤 역할을 수행하는지를 명확하게 표현하게 돕는다.
public class TransferService {
	
	public void transfer(String account, double amount) {
		System.out.println("Transfering " + amount + " to account, " + account);
	}
	
	public void checkBalance() {
		System.out.println("check balance");
	}
	
}
