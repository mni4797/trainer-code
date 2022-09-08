console.log("The same as System.out.printLine()");

console.log("===Variables===");

x = "Hello World";
console.log(typeof x);
x = 10.5145;
console.log(typeof x);
x = true;
console.log(typeof x);

console.log("===Null vs Undefined===");
let y;
let u = null;
console.log(y); //undefined
console.log(u); //null

console.log("===Objects===");
let pokeObj = {
    pokename: "Pikachu",
    level: 10,
    health: 100,
    damage: 50,

    attack: function() {
        console.log("Attacking!");
    },

    talk: (words) => {
        console.log(words);
    },

    getName: function(){
        //Make sure you use the this keyword whenever you want to refer to the object/class information
        return pokename;
    }
};

let pokename = "Stephen";
console.log(pokeObj);
pokeObj.talk(); //Undefined
// pokeObj.attack();
pokeObj.talk("Hello Hello!"); //Hello Hello!
//Anthony with error/exception run the code
console.log(pokeObj.getName()); //?? Undefined, Pikachu*3, 

class Pokemon {
    //By default, everything is public
    pokename;
    level;
    health;
    damage;

    //private field
    //You use hashtag for private field
    #damage;

    constructor(){
        this.pokename = "Pikachu";
        this.level = 10;
        this.health = 100;
        this.damage = 50;
        this.#damage = 10;
    }

    //This is a METHOD
    speak() {
        console.log("Pika pika!");
    }

    attack() {
        console.log("Attacking!");
    }
}

//Inheritance in JS uses extends keyword and works the same in Java
class Electric extends Pokemon {

}

poke1 = new Pokemon();
poke2 = new Pokemon();
poke3 = new Pokemon();
console.log(poke1);
poke1.damage = 150;
console.log("Pokemon damage: "+poke1.damage); //?? Why the heck can I still access the damage field

poke1.speed = 100;
console.log(poke1.speed);
console.log(poke1.health);

console.log("===Truthy & Falsey===")

console.log(0.5+0.1==0.6); //?? true
console.log(0.1+0.2==0.3); //?? true

console.log(99999999999999);

console.log(Math.max()); //?? Infinite, 100000000, false,undefined
console.log(Math.min());

console.log(true+true+true==3); //?? true, 
console.log(true-true);

console.log(!!112 == true); //?? 

console.log(typeof NaN); //value that means Not A Number

//More fun stuff!
console.log([] + []); //Adding two arrays will give an empty string
console.log([] - []); //Subtracting two arrays give you a 0
// console.log({} + []); // Gives you a 0
console.log([] + {}); // Gives you a object