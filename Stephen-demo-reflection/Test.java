package com.revature.friday.lecture.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//This is an annotation to tell our custom annotation to keep this annotation during runtime
//TDLR: we can use it in our reflection
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    
    //Will determine if it will run the unit test or not
    public boolean enable() default true;
}
