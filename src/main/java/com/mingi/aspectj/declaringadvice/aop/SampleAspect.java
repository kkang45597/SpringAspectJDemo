package com.mingi.aspectj.declaringadvice.aop;

import java.lang.reflect.Method;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import com.mingi.aspectj.declaringadvice.annotation.Auditable;
import com.mingi.aspectj.declaringadvice.model.MyType;

@Aspect
@Component
public class SampleAspect {

	 @Before("execution(* com.mingi.aspectj.declaringadvice.service.Sample+.sampleGenericMethod" + 
			 " && args(param))")
	 public void beforeSampleMethod(JoinPoint jp, MyType param) {
		 System.out.println("beforeSampleMethod: Before sampleGeneric with MyType param: " + param);
	 }
	 
	 @Before("execution(* com.mingi.aspectj.declaringadvice.service.Sample+.sampleGenericCollection" + 
			 " && args(param))")
	 public void beforeGenericCollection(JoinPoint jp, Collection<?> param) {
		 System.out.println("beforeSampleMethod: Before sampleGenericCollectionMethd "
		 		+ "with MyType param: " + param);
		 if(!param.isEmpty()) {
			 Object firstElemnet = param.iterator().next();
			 
			 if(firstElemnet instanceof MyType) {
				 System.out.println("First elemnet in collection is of type MyType: " + param);
			 }
		 }
	 }
	 
	 @Before("execution(* com.mingi.aspectj.declaringadvice.service.Sample+.sampleGenericMethod" + 
			 " && args(param))")
	 public void beforeSampleMethodForDetermingArgumentName(JoinPoint jp, MyType param) {
		 System.out.println("beforeSampleMethodForDetermingArgumentName");
		 MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		 Method method = methodSignature.getMethod();
		 
		 ParameterNameDiscoverer pnd = new StandardReflectionParameterNameDiscoverer();
		 String[] parameterNames = pnd.getParameterNames(method);
		 
		 if(parameterNames != null) {
			 for(String paraName : parameterNames) {
				 System.out.println("De");
			 }
		 }
		 else {
			 
		 }
	 }
	 
	 // argNames: 디버그 정보 없이 컴파일하거나, 
	 // 런타임에 "포인트컷을 해석하는 경우에는 어드바이스 선언에 사용된 아규먼트 이름을 사용할 수 없다.
	 // 이러한 상황에서만 어노테이션에 아규먼트 이름을 제공해야 한다.
	 // 이는 아규먼트가 달린
	 @Before(value = "execution(*  com.mingi.aspectj.declaringadvice.service.SampleService.*(..)) "
	 		+ " && target(bean) && @annotation(auditable)", 
	 		argNames = "bean,auditable")
	 public void audit (Object bean, Auditable auditable) {
		 String code = auditable.value();
		 System.out.println("Audit - Bean: " + bean.getClass().getName() + ", Code: "+ code);
	 }
	 
	 @Before(value = "execution(*  com.mingi.aspectj.declaringadvice.service.SampleService.*(..)) "
		 	+ " && target(bean) && @annotation(auditable)", 
		 	argNames = "bean,auditable")
	public void audit (JoinPoint jp, Auditable auditable) {
		 String code = auditable.value();
		 System.out.println("Method: " + jp.getSignature().getClass().getName());
		 System.out.println("Audit - JoinPoint: " + jp.getClass().getName() + ", Code: "+ code);
	}
}
