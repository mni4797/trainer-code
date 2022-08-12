package com.revature;

import com.revature.models.Pokemon;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String name = "Stephen Pagdilao"; //Variable

        Pokemon pokeobj1 = new Pokemon();
        pokeobj1.setName("Shrek");

        pokeobj1.doFunction(() -> {
            System.out.println("This is the functional interface running");
        });

        //Since Functional Interface2 hello2() method requires you to return a String
        //Our lambda expression must follow that method signature
        pokeobj1.doFunction2(() -> {
            return pokeobj1.getName();
        });

        pokeobj1.doFunction3((one, two) -> {
            one += "Shrek";
            
            //Hello ShrekWorld
            System.out.println(one + two);

        });
    }
}
