import React from 'react';
import logo from './logo.svg';
import './App.css';
import PokemonBox from './components/PokemonBox/PokemonBox';
import { IPokemon } from './models/Pokemon';
import Counter from './components/Counter/Counter';

/** 
 * This is what a component looks like and how we will make ours as well
 * 
 * The name of the component is determined by the name of the function
 * 
*/

function App() {

  const pokeobj1:IPokemon = {
    damage: 123,
    health: 548,
    img: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/146.png",
    level: 10,
    name: "Moltres"
  }

  const listOfPokemon: IPokemon[] = [
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
    }
  ]

  const helloWorldElement = <div>This is a element inside a variable!??</div>
  const someString = "This is a variable in TS being displayed"

  /**
   * What you are returning is called a JSX
   * 
   * It is essentially the blend between a JS and HTML, you can use JS and HTML together and seamless without any weird syntaxes that you have to do
   *  Ex: Want to put an HTML element inside a variable? You can
   * 
   * 
   * React wants everything in one file, it doesn't believe in seperating multiplo things in different files
   */
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <p>{someString}</p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>

      {helloWorldElement}

      {/* This is only one way to pass information into a component */}
      <PokemonBox damage={150} health={100} img="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png" level={10} name="Pikachu"/>

      {/* Using spread operator to act like what we did above */}
      <PokemonBox {...pokeobj1} />

      {/* 
        map function changes each element of the array into whatever you return
        list = [1, 4, 5, 6]
      
        list.map((element) => {
          element * 2
        })

        console.log(list) // [2, 8, 10, 12]

        Something problematic with React when it comes to displaying lists using a map
          - You must supply key attribute for each item
          - Generally just using some uniquely identifiable property in the list will be perfect (Ex: id)
          - When does React need this? To help identify specific HTML element that gets duplicated whenever you use a map generally
      */}
      {
        listOfPokemon.map((pokemon) => {
          return <PokemonBox key={pokemon.name} {...pokemon}/>
        })
      }

      <Counter />
    </div>
  );
}

export default App;
