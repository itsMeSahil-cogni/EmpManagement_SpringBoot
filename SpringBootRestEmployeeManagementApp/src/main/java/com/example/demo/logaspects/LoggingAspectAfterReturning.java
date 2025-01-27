package com.example.demo.logaspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect

@Component
public class LoggingAspectAfterReturning {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@AfterReturning("execution(* com.example.demo.service.EmployeeServiceImpl.*(..))")
	public void logAfterReturningAllMethods() throws Throwable {
		LOGGER.debug("****LoggingAspect.logAfterReturningAllMethods() ");
	}

	@AfterReturning(pointcut = "execution(* com.example.demo.service.EmployeeServiceImpl.getEmployee(..))", returning = "retVal")
	public void logAfterReturningGetEmployee(Object retVal) throws Throwable {
		LOGGER.debug("****LoggingAspect.logAfterReturningGetEmployee() ");
	}

	@AfterReturning("execution(* com.example.demo.service.EmployeeServiceImpl.addEmployee(..))")
	public void logAfterReturningAddEmployee() throws Throwable {
		LOGGER.debug("****LoggingAspect.logAfterReturningAddEmployee() ");
	}
}
