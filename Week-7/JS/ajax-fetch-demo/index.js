function getPokemon() {
    //Creating the variable that holds the id/name of the pokemon i wanna find
    // Navigating the DOM to find the element that has needToFindPokemon as its id and 
    // i'm assigning the value to a var
    let pokemon2Find = document.querySelector('#needToFindPokemon').value;

    // main character: XMLHTTPRequest object - this object is what we are packaging to send
    // http request and receive the http response
    let httpRequest = new XMLHttpRequest();

    // create the variable that holds the response data in a structured way
    let pokemon = {};

    //assemble the httprequest
    // first param is the httpverb
    // second param is the URL 
    // third param is whether or not you want to execute this async
    httpRequest.open('GET', `https://pokeapi.co/api/v2/pokemon/${pokemon2Find}`, true);

    // send the request
    httpRequest.send();

    // define what to do when we receive a response
    // The xmlhttprequest object has an onreadystate
    // This just describes the state of your request
    // 0 - uninitialized
    // 1 - loading (server connection established) the open method has been invoked
    // 2 - loaded (request received by server) send has been called
    // 3 - interactive (processing request) response body is being received
    // 4 - complete (response received) 

    httpRequest.onreadystatechange = function () {
        // checks if response has been received and if the operation was successful by checking if the status
        // codes are within the 2xxs
        if (this.readyState == 4 && this.status > 199 && this.status < 300) {
            // deserialize the json response body of the httpResponse
            // JSON.parse() parses the JSON string request body into a JS object
            // JS object takes in the structure of the JSON 
            pokemon = JSON.parse(httpRequest.responseText);
            //using combinator selectors I'm getting the img element that belongs to a tag with class pokemonResult
            // and setting its source attribute to whatever I'm getting from the pokeapi
            document.querySelector('.foundPokemon img').setAttribute('src', pokemon.sprites.front_default);

            // before we add a caption let's delete the existing one
            document.querySelectorAll('.foundPokemon caption').forEach(caption => caption.remove());

            // create a caption element to hold the pokemon name
            let caption = document.createElement('caption');
            caption.innerHTML = pokemon.forms[0].name;
            document.querySelector('.foundPokemon').appendChild(caption);

            // refresh the search text area
            document.querySelector('#needToFindPokemon').value = '';
        }
    }
}

function getDigimon() {
    let digimon2Find = document.querySelector('#needToFindDigimon').value;
    // fetch function by defualt with just one param you send a get request to the url
    // to edit the method, add any request headers, add additional parameters
    // check documentation for more details
    fetch(`https://digimon-api.vercel.app/api/digimon/name/${digimon2Find}`)// returns a promise
        .then(result => {
            if (result.ok) {
                return result.json();
            } else {
                throw new Error("Digimon not found");
            }
        })
        // this then defines what happens when a promise is fulfilled ie a response was given to us from the server
        // the .json() function that returns the response body and maps it to a JS object
        // returns another promise
        .then(digimon => {
            document.querySelector('.foundDigimon img').setAttribute('src', digimon[0].img);
            document.querySelectorAll('.foundDigimon caption').forEach((element) => element.remove());
            let caption = document.createElement('caption');
            caption.appendChild(document.createTextNode(digimon[0].name));
            document.querySelector('.foundDigimon').appendChild(caption);
            document.querySelector('#needToFindDigimon').value = '';
        }).catch(error => {
            document.querySelectorAll('.foundDigimon caption').forEach((element) => element.remove());
            let caption = document.createElement('caption');
            caption.appendChild(document.createTextNode(error.message));
            document.querySelector('.foundDigimon').appendChild(caption);
            document.querySelector('#needToFindDigimon').value = '';
        })
}
