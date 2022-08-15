package com.revature;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Do you know how type safety works and conversion?" );

        Object obj = new Object();
        Integer intNum = Integer.valueOf(10);
        
        Double doubleNum = Double.valueOf(10.6);
        Float floatNum = Float.valueOf(80);
        

        //Yes we can, because all class inherits from Object
        obj = intNum;

        // Yes - all
        method1(intNum); 
        method1(doubleNum);
        method1(floatNum);

        List<Integer> intList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<Float> floatList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        //Yes - 4, No - 3
        // method2(intList); //Yes, No
        // method2(doubleList); //Yes, No
        // method2(floatList); //Yes, No
        method2(numberList);

        /**
         * Subtyping is when you want to check the subtype of a generic class not the actual class itself when you want to do typesafety
         * Really only matters to generic classes 
         */

    }

    public static void method1(Number num){

    }

    public static void method2(List<Number> numlist){
        //implementation to add it on 
    }
}
