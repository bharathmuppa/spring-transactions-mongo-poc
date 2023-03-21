package com.example.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;


@Aspect
@Component
public class CheckEmployeeIsFunnyAnnotationProcessor {

	@Around("@annotation(checkEmployeeIsFunny)")
	public Object onSaveEmployeeExecuted(ProceedingJoinPoint point, CheckEmployeeIsFunny checkEmployeeIsFunny) throws Throwable {
		if (checkEmployeeIsFunny.value()) {
			return point.proceed(point.getArgs());
		}
		throw new RuntimeException("Employee is not funny!");
	}

}
