package com.mingi.aspectj.declaringpoincut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mingi.aspectj.declaringpoincut.service.SpecialService;
import com.mingi.aspectj.declaringpoincut.service.TransferService;

@Configuration
@ComponentScan(basePackages = "com.mingi.aspectj.declaringpoincut") // 스프링 IoC 컨테이너에게 지시
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public SpecialService specialService() {
		return new SpecialService();
	}
	
	@Bean
	public TransferService transferService() {
		return new TransferService();
	}

}
