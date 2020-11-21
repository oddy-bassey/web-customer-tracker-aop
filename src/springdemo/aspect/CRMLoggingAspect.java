package springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	//setup pointcut declarations
	
	//setup pointcut declarations for controller
	@Pointcut("execution(* springdemo.controller.*.*(..))")
	public void controllerPackage() {
		
	}
	
	//setup pointcut declarations for services 
	@Pointcut("execution(* springdemo.service.*.*(..))")
	public void servicePackage() {
		
	}
	
	//setup pointcut declarations for dao 
	@Pointcut("execution(* springdemo.dao.*.*(..))")
	public void daoPackage() {
		
	}
	
	//combine pointcuts 
	@Pointcut("controllerPackage() || servicePackage() || daoPackage() ")
	public void appFlow() {
		
	}
	
	//add @Before advice
	@Before("appFlow()")
	public void before(JoinPoint joinPoint) {
		
		//display method being called
		String method = joinPoint.getSignature().toShortString();
		logger.info("==>> in @Before: calling method: "+method);
		
		//display arguments to the method
		
		//get arguements
		Object[] args = joinPoint.getArgs();
		
		//loop through and display args
		for(Object data : args) {
			logger.info("==>> arguement: "+data);
		}
	}
	
	//add @AfterLogging advice
	@AfterReturning(pointcut="appFlow()", returning="result")
	public void after(JoinPoint joinPoint, Object result) {
		//display method being called
		String method = joinPoint.getSignature().toShortString();
		logger.info("==>> in @AfterReturning: calling method: "+method);	
		
		//display data
		logger.info("==>> result: "+result);
	}
}








