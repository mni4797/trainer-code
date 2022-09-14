import { useState } from 'react';
import { IPokemon } from '../../models/Pokemon';
import './PokemonBox.css';

/**
 * Will display pokemon info in a box UI
 * 
 * In the event where you want your information displayed in this component to dynamically change, use props
 */

interface IProps extends IPokemon {
    counter?:number,
    onButtonClick?():void
}


function PokemonBox(props:IProps) {
    

    // Put this state in the common ancestry of all the child components you want to share the information to
    // function incrementCounter() {
    //     setCounter(counter + 1);
    // }


    return <div className="container">
        <img src={props.img}/>
        <p>{props.counter}</p>
        <p>Name: {props.name}</p>
        <p>Level: {props.level}</p>
        <p>Health: {props.health}</p>
        <p>Damage: {props.damage}</p>
        <button onClick={props.onButtonClick}>+</button>
    </div>
}

export default PokemonBox;