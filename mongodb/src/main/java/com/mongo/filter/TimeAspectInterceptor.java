package com.mongo.filter;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspectInterceptor {
	Logger logger = LoggerFactory.getLogger(TimeAspectInterceptor.class);
//	com.mongo.service.impl.CarServcieImpl.findByCondition(CarDoc)
	 @Pointcut("execution(* com.mongo.service.impl.CarServcieImpl.findByCondition(..))")  
    private void anyController(){}//定义一个切入点  
	 
	 @Pointcut("execution(* com.mongo.service..*.*(..))")
	 private void anyService(){}
	 
	 @Pointcut("execution(* com.mongo.repository..*.*(..))")
	 private void anyDao(){}
	 
	 File File = new File("e:/test/time.txt");
	 
//    @Around("anyMethod() || anyService() || anyDao() ")  
    @Around(" anyController()")  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{  
    	String methodName = pjp.getSignature().getDeclaringTypeName()+"."+pjp.getSignature().getName();
//    	logger.info(methodName+"方法开始");
    	long startTime = System.currentTimeMillis();
        Object object = pjp.proceed();//执行该方法  
        long endTime = System.currentTimeMillis();
//        logger.info(methodName+"方法结束");
        logger.info(methodName+"方法耗时："+(endTime-startTime)+"毫秒");
        BufferedWriter writer = new BufferedWriter(new FileWriter(File,true));
        try {
        	writer.write((endTime-startTime)+"");
        	writer.newLine();
			writer.flush();
		} finally {
			writer.close();
		}
        return object;  
    }  
}
