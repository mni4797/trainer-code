package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.Dao;
import com.revature.dao.PokemonDao;
import com.revature.models.Pokemon;

public class PokemonController extends HttpServlet{
    
    private static Dao<Pokemon> pokedao = new PokemonDao();
    /**
     * This method is responsible with hanlding all the get requests
     * 
     * But what if you need multiple get requests from the same Controller?
     * Ex:
     * Note - pokemon controller
     * What if I want to grab all the pokemons from my database?
     * What if I want to grab one pokemon from my database depending id?
     * 
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        /**
         * Ex:
         * http://localhost:8080/rest/pokemon -> pokemon
         * http://localhost:8080/rest/allpokemon -> allpokemon
         * 
         */


        // TLDR - will grab the last thing on our URL
        // "/rest/" - will depend on your project name (case-sensitive)
        final String URI = req.getRequestURI().replace("/rest/", "");

        //We need to specify that what we are about to give is a JSON information
        resp.setContentType("application/json");
        
        switch (URI) {
            case "pokemon":
                // resp.getWriter().println("I am getting one pokemon");
                
                break;
            case "allpokemon":
                // resp.getWriter().println("I am getting multiple pokemon");
                
                //Displaying the result of our dao logic
                List<Pokemon> listOfPoke = pokedao.getAllInstance();



                break;
            default:
                break;
        }
    }
}
