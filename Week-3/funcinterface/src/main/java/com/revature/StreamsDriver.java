package com.revature;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Stream API
 * It is used to process/manipulate a collection of objects
 * Streams needs a data source and it can be from Collection, Array, or even IO channels
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 */

public class StreamsDriver {

    public static void main(String[] args){
        List<String> listOfNames = Arrays.asList("Shrek", "Donato", "Trenton", "Win", "wint", "Tariq");
    
        //Show you the one of the ways we can iterate
        //Go find all the Ws
        listOfNames.forEach((element) -> {
            element = element.toUpperCase();
            if (element.startsWith("W")) {
                System.out.println(element);
            }
        });

        System.out.println("===Stream way===");
        listOfNames.stream()
            .map(element -> element.toUpperCase()) //Will manipulate each element and change it somehow
            .filter(element -> element.startsWith("W")) //Will filter the collection of object
            .sorted() //Will sort our element
            .forEach(element -> System.out.println(element)); //Will display each of our element

        System.out.println("===Fancier Way===");
        listOfNames.stream()
            .map(String::toUpperCase) //method reference
            .filter(element -> element.startsWith("W"))
            .sorted()
            .forEach(System.out::println); //We method reference System.out println() method to use in our foreach
    
        //What if you want to store the result of this stream api??
        //But why optional class. It is to prevent stream api from giving a null result
        //Optional class may or may not give a value
        //The whole point was to prevent giving a null to indicate that our stream api didn't find anything
        System.out.println("===Optional Demo===");
        Optional<String> filterName = listOfNames.stream()
            .map(String::toUpperCase) //method reference
            .filter(element -> element.startsWith("A"))
            .sorted()
            .findFirst(); // Terminal operation - end of the line of this stream api that will give a result

        for (String string : listOfNames) {
            System.out.println(string);
        }

        System.out.println(filterName);
    }


}
