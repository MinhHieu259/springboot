package com.minnhieu.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {
    private static Logger logger = Logger.getLogger(String.valueOf(LoggerAspect.class));
    @Pointcut("execution(* com.minnhieu.springboot.*.*.*(..))")
    private void generalPointcut(){

    }

    @AfterThrowing(pointcut = "generalPointcut() throws Exception", throwing = "ex")
    public void exceptionLog(JoinPoint joinPoint, Exception ex) throws Exception{
        logger.info(joinPoint.getTarget().getClass().getSimpleName()+" : "+joinPoint.getSignature().getName()
        +" : "+ ex.getMessage());
    }

    @Before("generalPointcut()")
    private void infoLog(JoinPoint joinPoint){
        logger.info(joinPoint.getTarget().getClass().getSimpleName()+" : "+joinPoint.getSignature().getName());
    }
}
