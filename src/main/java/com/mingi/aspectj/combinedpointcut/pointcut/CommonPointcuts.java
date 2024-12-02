package com.mingi.aspectj.combinedpointcut.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class CommonPointcuts {
	
	// web 패키지와 그 하위 패키지에 있는 모든 조인 포인트
	@Pointcut("within(com.mingi.aspectj.combinedpointcut.web..*)")
	public void inWebLayer() { }
	
	// service 패키지와 그 하위 패키지에 있는 모든 조인 포인트
	@Pointcut("within(com.mingi.aspectj.combinedpointcut.service..*)")
	public void inServiceLayer () { }
	
	@Pointcut("within(com.mingi.aspectj.combinedpointcut.dao..*)")
	public void inDataAccessLayer () { }
	
	// service.*: service 패키지 내의 모든 클래스
	// service.*.*(..): service 내의 모든 메서드, 파라미터 제한 없음
	@Pointcut("execution(* com.mingi.aspectj.combinedpointcut.service.*.*(..))")
	public void businessService() { }
	
	@Pointcut("execution(* com.mingi.aspectj.combinedpointcut.dao.*.*(..))")
	public void dataAccessOperation() { }
}
