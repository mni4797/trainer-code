// Functions in JS
// Functions are the building blocks of JS
// They're your event handlers, they execute logic

// Classic Function aka basic function
function basicFunction() {
    console.log('This is a basic function');
}

basicFunction();

// callback function
function parent(someCallback) {
    console.log("in parent");
    someCallback();
    console.log("back to parent");
}

function callback() {
    console.log("in callback");
}
function callback2(name) {
    console.log("in callback. Hello " + name);
}
// you can pass any function as a callback
// you can pass any number of parameters to functions
parent(callback);
parent(callback2);
//parent(parent);
// anonymous function
let catMeow = () => {
    console.log("meows");
}
catMeow();
parent(() => console.log("the callback is anonymous"));

// IIFE aka Immediately invoked function expression
(
    () => {
        console.log("immediately invoked woof");
    }
)();
(
    function iify() {
        console.log("immediately invoked function");
    }
)();

let closure = (
    function outer() {
        let ctr = 0;
        return function inner() {
            return ctr++;
        }
    }
)();

let counter = closure;
console.log('counter: ' + counter()); // 0
console.log('counter: ' + counter()); //1

let counter2 = closure;
console.log('counter2: ' + counter2()); //0
console.log('counter2: ' + counter2()); //1
console.log('counter2: ' + counter2()); //2
console.log('counter2: ' + counter2());//3
console.log('counter: ' + counter())

// Closures with and without iffes
// closure without iffe - similar to prototypal scope, new instance of ctr var
// closure with iffe - similar to singleton, the value of the counter is shared 