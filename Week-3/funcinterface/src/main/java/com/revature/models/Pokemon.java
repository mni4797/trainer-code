package com.revature.models;

import com.revature.utils.FunctionalInterface1;
import com.revature.utils.FunctionalInterface2;
import com.revature.utils.FunctionalInterface3;

public class Pokemon {
    private String name; //Field
    private int level;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public void doFunction(FunctionalInterface1 func){

        System.out.println("do function1 is running");

        func.hello();
    }

    public void doFunction2(FunctionalInterface2 func){
        System.out.println("do function2 is running");

        System.out.println(func.hello2());
    }

    public void doFunction3(FunctionalInterface3 func){
        System.out.println("do function3 is running");

        //The two parameters we pass in the functional interface
        //Will be used by the lambda expression
        func.hello3("Hello ", "World");
    }
}
