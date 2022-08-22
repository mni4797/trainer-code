package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.Dao;
import com.revature.dao.PokemonDao;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

public class PokemonController extends HttpServlet{
    
    private static PokemonService pokeserv = new PokemonService(new PokemonDao());
    private static ObjectMapper objmap = new ObjectMapper();

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
        String jsonString;

        switch (URI) {
            case "pokemon":
                // resp.getWriter().println("I am getting one pokemon");
                Integer id = 0;

                try {
                    id = Integer.parseInt(req.getParameter("id"));
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }

                Pokemon foundPokemon = pokeserv.getPokemonById(id);

                jsonString = objmap.writeValueAsString(foundPokemon);

                resp.getWriter().println(jsonString);

                break;
            case "allpokemon":
                // resp.getWriter().println("I am getting multiple pokemon");
                
                //Displaying the result of our dao logic
                List<Pokemon> listOfPoke = pokeserv.getAllPokemon();

                jsonString = objmap.writeValueAsString(listOfPoke);

                resp.getWriter().println(jsonString);

                break;
            default:
                //In the event that someone tried to access get request that isn't allowed
                //I've used the super method of doGet because that already returns a 405 method not allowed in a proper way
                super.doGet(req, resp);
                break;
        }
    }

    //Handles post requests
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        final String URI = req.getRequestURI().replace("/rest/", "");

        resp.setContentType("application/json");

        switch (URI) {
            case "addpokemon":
                // resp.getWriter().println("You are trying to add a pokemon");

                //Grabs the json body into one long string
                String jsonString = req.getReader().lines().collect(Collectors.joining());

                //readValue() takes into two parameters one is the json string and the other is what object is should map the info into
                Pokemon pokemon = objmap.readValue(jsonString, Pokemon.class);

                //Saves the generated id by SQL
                pokemon = pokeserv.addPokemon(pokemon);

                //Convert it back to json string
                jsonString = objmap.writeValueAsString(pokemon);

                //Send that to the client after creation
                resp.getWriter().println(jsonString);

                break;
            default:
                super.doPost(req, resp);
                break;
        }
    }
}
