package com.revature.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
    // logger
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @After("execution (* com.revature.springaop.services.*.*(..))")
    public void after(JoinPoint jPoint) {
        log.info("After execution of this method: {}", jPoint);
    }

    // value defines at what method we are intercepting and returning defines the
    // variable name that we're saving the return value of the method to
    @AfterReturning(value = "execution (* com.revature.springaop.services.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint jPoint, Object result) {
        log.info("{} returned a value of {}", jPoint, result);
    }

    // intercept exceptions thrown by method
    @AfterThrowing(value = "execution (* com.revature.springaop.services.*.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Object exception) {

        log.info("{} throws exception {}", joinPoint, exception);

    }
}
// main method => service.getSomething()
// before service.getSomething() gets executed, before() executes first
// service.getSomething() executes
// before going back to the main method
// afterReturning() gets executed, followed by after()
// then we return to main method