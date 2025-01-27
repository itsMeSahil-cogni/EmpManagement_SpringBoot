package com.example.demo.logaspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfterThrowing {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@AfterThrowing(pointcut = "execution(* com.example.demo.service.EmployeeServiceImpl.*(..))", throwing = "ex")
	public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
		LOGGER.debug("****LoggingAspect.logAfterThrowingAllMethods() " + ex);
	}
}
