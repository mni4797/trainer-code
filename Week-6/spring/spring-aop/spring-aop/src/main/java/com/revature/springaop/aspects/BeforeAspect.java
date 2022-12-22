package com.revature.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // an aspect is a modularization of a concern that cuts across multiple classes
@Configuration // this annotation tells Spring to configure this aspect into the global
               // application context
public class BeforeAspect {
    // logger
    // You get a slf4j logger with spring boot
    private Logger log = LoggerFactory.getLogger(this.getClass());

    // Create an advice
    // execution(access_specifier package_name class_name
    // method_name(argument_list))
    @Before("execution (* com.revature.springaop.services.*.*(..))") // SpEl - Spring Expression language to define a
    // pattern of methods we want to intercept
    public void before(JoinPoint jPoint) {
        log.info("Look what I intercepted before it even started {}", jPoint);
    }

    /**
     * - JoinPoint: is the opportunity to intercept (almost always a method)
     * - PointCut: the specific pattern of methods that we're intercepting
     * - Aspect: the combo of advice + a point cut
     * - Advice: the implementation of what to do at the pointcut, and
     * when @Before, @After, @Around
     * 
     * Restaurant Analogy:
     * 
     * The menu is the JoinPoint(all the foods that you CAN order)
     * Your order is the PointCut (the specific food you order a.k.a the pattern
     * defined in Spring Expression Language)
     */
}
