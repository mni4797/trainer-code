import React, { useState } from "react";
import { IPokemon } from "../../models/Pokemon";
import PokemonBox from "../PokemonBox/PokemonBox";
import "./PokemonList.css";

function PokemonList() {

    //This will hold whatever the user is typing in our website
    const [newPokemon, setNewPokemon] = useState<IPokemon>({
        damage: 0,
        health: 0,
        img: "",
        level: 0,
        name: ""
    });

    //This will be a list of IPokemon[]
    const [listOfPoke, setListOfPoke] = useState<IPokemon[]>([
        {
          damage: 80,
          health: 100,
          img: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/63.png",
          level: 20,
          name: "Abra"
        },
        {
          damage: 100,
          health: 20,
          img: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png",
          level: 12,
          name: "Ekans"
        },
        {
            damage: 123,
            health: 548,
            img: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/146.png",
            level: 10,
            name: "Moltres"
          }
      ]);


    /*
        Step by step process to make React forms work in React
            - Each input will be attached to a function

    */

    function updateName(event: React.ChangeEvent<HTMLInputElement>) {

        //This will grab the value of the input box
        newPokemon.name = event.target.value;

        //We are saving the the user's interaction with the input to our state
        setNewPokemon(newPokemon);

        console.log(newPokemon.name);
    }

    function updateLevel(event: any) {
        newPokemon.level = event.target.value;

        setNewPokemon(newPokemon);
    }

    function updateHealth(event: any) {
        newPokemon.health = event.target.value;

        setNewPokemon(newPokemon);
    }

    function updateDamage(event: any) {
        newPokemon.damage = event.target.value;

        setNewPokemon(newPokemon);
    }

    function updateImg(event: any) {
        newPokemon.img = event.target.value;

        setNewPokemon(newPokemon);
    }

    //This is function/behavior you want to execute the moment someone hits that submit button
    function onSubmit(event: React.FormEvent<HTMLFormElement>) {
        //If you don't put this line, it won't work
        event.preventDefault();

        /*
            The way hooks detect changes if the variable reference point changes
            doing a push on a list doesn't really change the reference point of our variable

            TLDR: check if the reference variable points to a new object, this will detect the changes
        */

        setListOfPoke([...listOfPoke, newPokemon]);

        console.log(listOfPoke);
    }

    return <div>
        <div>
            <h3>Add Pokemon</h3>
            <form className="form-grid" onSubmit={onSubmit}>
                <label>Name</label>
                <input type="text" onChange={updateName}/>
                <label>Level</label>
                <input type="number" onChange={updateLevel}/>
                <label>Health</label>
                <input type="number" onChange={updateHealth}/>
                <label>Damage</label>
                <input type="number" onChange={updateDamage}/>
                <label>Image</label>
                <input type="text" onChange={updateImg}/>
                <div></div>
                <input className="btn" type="submit" value="Submit Pokemon" />
            </form>

            <h3>Pokemon List</h3>
            <div className="list-grid">
                {
                    listOfPoke.map((pokemon) => {
                        return <PokemonBox key={pokemon.name} {...pokemon}/>
                    })
                }
            </div>
        </div>
    </div>
}

export default PokemonList;