package com.revature.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.revature.dao.Dao;
import com.revature.dao.PokemonDao;
import com.revature.models.Pokemon;

/**
 * What is the purpose of Service/Business Logic?
 * 
 * This is if we need any further process or actual heavy logic on what we need to do with our data
 * 
 * In the real world, we hate access the database as much as possible since it takes waay too long to get information
 * So we created services that will do some caching logic and optimize ways to reduce accessing the db
 * 
 * We will not do caching logic since that itself is a monster of a thing to achieve
 * Instead, we will utilize services for custom logic
 */
public class PokemonService {
    
    //=============== Dependency Injection ===============
    //It is a design pattern that will ensure that you have to provide an object during the creation of this object
    //why? becaust it DEPENDS on it to function properly
    //This ensures that whenever we make a pokemonservice obj it needs a pokemondao object
    private Dao<Pokemon> pokedao;

    public PokemonService(Dao<Pokemon> pokedao) {
        this.pokedao = pokedao;
    }
    //=====================================================

    
    //This is normally where you can do caching capabilities and detect changes grab new ones and so on..
    public List<Pokemon> getAllPokemon(){
        return pokedao.getAllInstance();
    }

    public Pokemon getPokemonById(int id){
        //What API should I use to filter and great for handling nulls in the event that happens?
        List<Pokemon> listOfPokemon = getAllPokemon(); 

        Optional<Pokemon> foundPoke = listOfPokemon.stream()
            .filter(pokemon -> pokemon.getId() == id)
            .findFirst();

        foundPoke.get().setName(foundPoke.get().getName().toUpperCase());
            
        if (foundPoke.isPresent()) {
            return foundPoke.get();

        } else {
            Pokemon noPoke = new Pokemon();
            noPoke.setName("No pokemon was found");

            return noPoke;
        }
    }

    //NO further processing required
    public Pokemon addPokemon(Pokemon poke){
        return pokedao.addInstance(poke);
    }

}
