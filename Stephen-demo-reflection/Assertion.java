package com.revature.friday.lecture.demo;

import java.util.Arrays;

public class Assertion {
    
    //Expected is the value you want
    //Actual is the value it displayed instead
    public static void Equals(int expected, int actual)
    {
        Evaluate(expected == actual, "Equals Failed");
    }

    public static void Equals(String expected, String actual)
    {
        Evaluate(expected.equals(actual), "Equals Failed");
    }

    public static void ArrayEquals(int[] expected, int[] actual)
    {
        Evaluate(Arrays.equals(expected, actual), "Array Equals Failed");
    }

    public static void ArrayEquals(String[] expected, String[] actual)
    {
        Evaluate(Arrays.equals(expected, actual), "Array Equals Failed");
    }

    //private Evaluate will check based on a condition if it should throw an exception or not
    private static void Evaluate(boolean condition, String message)
    {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
