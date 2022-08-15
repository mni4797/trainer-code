package com.revature.utils;

@FunctionalInterface //This annotation will tell the compiler this is supposed to be a functional interface and give lines if it voilates the rule of being a SAM
public interface FunctionalInterface1 {
    void hello();

    //Default keyword does not violate SAM rules because this method already has implementation details
    //Default means that if you don't implement this method, by default it will have the behavior
    //you stated in this interface
    default void test(){
        System.out.println("By Default, Testing");
    }
}
