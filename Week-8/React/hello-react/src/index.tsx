import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import PokemonBox from './components/PokemonBox/PokemonBox';
import PokemonList from './components/PokemonList/PokemonList';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NavBar from './shared/NavBar/NavBar';

/*
  Index.tsx is your main entry point for components in your program
  Anything in here is what will be displayed

  Since React is SPA, this is going to the main HTML page that will be served first

*/

//It will grab the div element in your index.html and put your components there using JS
const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

//This section is responsible for serving your actual components
root.render(
  <React.StrictMode>
    {/* <App /> */}
    {/* <PokemonList /> */}
    <BrowserRouter>
      
      <NavBar />

      <Routes>
        <Route path="/" element={<App/>}/>
        <Route path="/pokeList" element={<PokemonList />}/>
      </Routes>

      {/* You would put the footer here */}
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
