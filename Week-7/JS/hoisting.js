// Function hoisting - v common
catMeow();

function catMeow() {
    console.log('meow');
}

// var hoisting
// in summary, initialize your vars before you use them to avoid unexpected errors
console.log(willExist);
var willExist = 'I exist';

let shallExist = 'I exist';
console.log(shallExist);


