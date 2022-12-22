package com.revature.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {
    // Goal: Intercept the the service layer's methods and calculate how long it
    // takes it to execute
    // in milliseconds using @Around
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("execution (* com.revature.springaop.services.*.*(..))")
    public Object around(ProceedingJoinPoint pJoinPoint) throws Throwable {
        // proceeding Join Point allows us to track the method as it's executing

        // capture start time of method
        long start = System.currentTimeMillis();

        // give the method permission to continue execution
        // we need to save the result of this execution and return it
        // so that the original method caller can access the result
        Object result = pJoinPoint.proceed();

        // capture the end time of the method
        long end = System.currentTimeMillis();

        // calculate the total time method took to execute
        long timeTaken = end - start;

        log.info("The time it took {} to execute is {} milliseconds", pJoinPoint, timeTaken);
        return result;
    }
}
