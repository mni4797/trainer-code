package com.revature;

import java.util.ArrayList;
import java.util.List;

public class WildcardDriver {
    public static void main(String[] args){
        System.out.println("Wildcard demo");

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(50);
        intList.add(78);

        List<String> stringList = new ArrayList<String>();
        stringList.add("hello");
        stringList.add("Is it me your looking for");

        List<Object> objectList = new ArrayList<>();

    
        listElement(intList);
        listElement(stringList);
        listElement(objectList);

        //Will not work because string/object doesn't extend Numbers
        // addAll(stringList);
        // addAll(objectList);

        //Will work because Integer class does extend Numbers
        System.out.println(addAll(intList));
    }

    /**
     * Wildcards is like generic but we are referencing the subtype of a generic
     * Essentially if you want the compiler to make the subtype act like an normal inhertance rules
     */

    // Example of a unbound wildcard
    //I want to make a method that will take in a List collection and display its contents
    public static void listElement(List<?> list){
        for (Object object : list) {
            System.out.println(object);
        }
    }

    //Example of Bounded wildcard specifically a upper bound wildcard
    //I want this method to sum all the numerical numbers in a list
    //This is great for READ-ONLY
    public static double addAll(List<? extends Number> list){
        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }

    //Example of a lower bound wildcard
    //This is great for WRITE-ONLY
    public static void addTen(List<? super Number> list){
        list.add(10);
        list.add(10.6);
    }

    /**
     * In a more detailed note, the lower and upperbound wildcard will determine the "type safetly" of the argument
     * 
     * So a nicer rule of thumb to help you determine which one to use is, Upper is for read only and lower is for write only
     * 
     * What if you want to use read and write? Use generic T/E and not wildcards
     */

}
