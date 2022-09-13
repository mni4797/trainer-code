import { IPokemon } from '../../models/Pokemon';
import './PokemonBox.css';

/**
 * Will display pokemon info in a box UI
 * 
 * In the event where you want your information displayed in this component to dynamically change, use props
 */

function PokemonBox(props:IPokemon) {
    return <div className="container">
        <img src={props.img}/>
        <p>Name: {props.name}</p>
        <p>Level: {props.level}</p>
        <p>Health: {props.health}</p>
        <p>Damage: {props.damage}</p>
    </div>
}

export default PokemonBox;