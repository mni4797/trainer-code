import axios from "axios";
import React, { useEffect, useState } from "react";
import { IPokemon } from "../../models/Pokemon";
import { useAppSelector } from "../../shared/Redux/hooks";
import { selectTrainer } from "../Login/TrainerSlice";
import PokemonBox from "../PokemonBox/PokemonBox";
import "./PokemonList.css";

function PokemonList() {

    const trainer = useAppSelector(selectTrainer);

    //Moved the state to the common ancestry
    const [counter, setCounter] = useState(0);

    //This will hold whatever the user is typing in our website
    const [newPokemon, setNewPokemon] = useState<IPokemon>({
        damage: 0,
        health: 0,
        img: "",
        level: 0,
        name: ""
    });

    //This will be a list of IPokemon[]
    const [listOfPoke, setListOfPoke] = useState<IPokemon[]>(trainer.listOfPokemon);

    /*
        Do note that useEffect will execute the callback function you gave when it detects a change
        One of these changes is whenever a state changes
    */
    // useEffect(() => {
    //     // axios.get<IPokemon[]>("http://smresteb-env.eba-u2i9uhvs.us-east-1.elasticbeanstalk.com/rest/allpokemon")
    //     //     .then( response => {
    //     //         console.log(response.data);
    //     //         setListOfPoke(response.data);
    //     //     })


    // }, []) //Empty array as the second parameter will prevent an infinite loop of forever calling the backend
    
    function handleButtonClick() {
        console.log("Detected click from a component!");
        setCounter(counter + 1);
    }

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

        //Logic to do a post request and add the pokemon object
        axios.post<IPokemon>("http://smresteb-env.eba-u2i9uhvs.us-east-1.elasticbeanstalk.com/rest/addpokemon",newPokemon)
            .then(response => {
                console.log(response);
            });
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
                        return <PokemonBox key={pokemon.id} {...pokemon} counter={counter} onButtonClick={handleButtonClick}/>
                    })
                }
            </div>
        </div>
    </div>
}

export default PokemonList;