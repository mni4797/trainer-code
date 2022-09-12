import React from 'react';
import logo from './logo.svg';
import './App.css';

/** 
 * This is what a component looks like and how we will make ours as well
 * 
 * The name of the component is determined by the name of the function
 * 
*/


function App() {

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
