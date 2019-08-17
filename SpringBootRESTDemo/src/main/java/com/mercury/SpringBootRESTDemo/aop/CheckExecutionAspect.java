package com.mercury.SpringBootRESTDemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckExecutionAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Point cut + Advice
	
	// 					*: 表示any return type is ok.	*Service所有带有Service的，..表示任何都可以
	@Pointcut("execution(* com.mercury.SpringBootRESTDemo.service.*Service.*(..))")
	public void getJoinPoint() {
		
	}
	
	// Around: 执行前或后，Before：之前，@AfterReturning, @AfterThrowing
	// After: after finally，不管程序有没有exception都会执行
	@Before("getJoinPoint()")
	public void checkExecutionAdvice(JoinPoint jp) {
		// get method signature: eg.public void updateOrder(Order order)
		logger.info(jp.getSignature().getName() + " was invoked.");
	}
	
	@Around("getJoinPoint()") // 可以在执行After, Before, AfterReturning, AfterThrowing
	public Object muteSamples(ProceedingJoinPoint pjp) throws Throwable { // 所有和sample相关的方法都不会执行
		Object result = null;
		if (pjp.getSignature().getName().contains("Sample")) {
			logger.info("service is muted!");
		} else {
			
			try {
				logger.info("before function executes");
				result = pjp.proceed();
				logger.info("after function return");
			} catch(Throwable t) {
				logger.info("after function throws");
			} finally {
				logger.info("after function finally");
			}
			
		}
		return result;
	}
	
	/*
	// Before
	public int test() {
		if (Math.random() > 0,5) {
			return 1;
			// @AfterReturning
		} else {
			throw new RuntimeException();
			// @AfterThrowning
		}
	}
	// After
	 */
}
