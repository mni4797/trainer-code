/*
    TypeScript must be installed via NPM
        - npm install -g typescript
        - Make sure to change Execution Policy to remotesigned

    Must transpile TS into JS for any web browser to support it
        - tsc [TSfilepath]
        - tsc -w [TSfilepath]
        - tsc -w -t es6 [TSFilepath]
*/

console.log("===Variable===");
//TS will automatically assign s1 into a String because that is the value you have given it
let s1 = "Hello";

// s1 = 10; //We have strongly typed back! Will not be able to give s1 the value of 10 because it is a number

console.log(s1);

let n1:number;
n1 = 10;
n1 = 10.3;

console.log(n1);

let a1:any;
a1 = 10.3;
a1 = true;
a1 = "Hello";

//You can have multiple datatypes into a single variable
let m1: string | number;
m1 = "Hello";
m1 = 10.8;
// m1 = false; Gives an error because boolean

//Arrays
let arr1:any[];
arr1 = ["String", 10, true];
arr1.push(false);
console.log(arr1);

let arr2:(number | boolean)[];
arr2 = [true, false, 10, 21.32];

let arr3: number | boolean[];
arr3 = 10;
arr3 = [true, false, true];

//Tuple - It is like an array but can only contain fixed size and the order matters
let tul1:[number, string];
tul1 = [10.5, "Hello0"];
tul1.push(10.5);
console.log(tul1);

let tul2: [string, boolean, number];
tul2 = ["String", true, 10.6];

//Enum - works like a normal enum in Java
enum Engine {
    Off = 0,
    Idle = 1,
    Accel = 2
}

let engineState = 0;

if (engineState == Engine.Off) {
    console.log("The engine is off");
}

console.log("===Function===");

function PrintHelloWorld() : void {
    console.log("Hello World");
}

PrintHelloWorld();

//Functions in TS will need to supply a datatype and return datatype
function myFunct(para1:string, para2:string): string {
    return para1 + para2;
}

console.log(myFunct("Hello", " World"));

console.log("===Interface===");

// Naming convention with interfaces starts with an I, this is also what we do in C#
interface IPokemon {
    name:string,
    level:number,
    health:number,
    damage:number,
    speed?:number, //Optional properties

    talk():void, //Like interfaces in Java, you don't add implementation details to a method

    attact?():string //Optional method
}

let obj1:IPokemon

obj1 = {
    damage: 100,
    health: 100,
    level: 15,
    name: "Pikachu",
    speed: 100,

    talk: () => {
        console.log("Pika Pika!");
    }
}

obj1.talk();

class Electric implements IPokemon {
    /*
        Access modifiers are back!
        * public - everyone has access to it
        * protected - the class and the subclasses have access to it
        * private - only the class have access
    */

    name: string;
    level: number;
    health: number;
    damage: number;

    //How do we access it outside?
    private passive:string;

    constructor() {
        this.name = "Pikachu";
        this.level = 10;
        this.health = 100;
        this.damage = 120;
        this.passive = "Lightning Rod";
    }

    talk(): void {
        throw new Error("Method not implemented.");
    }
    attact?(): string {
        throw new Error("Method not implemented.");
    }
    
    /*
        This is how make a getter and setter
        Also known as Accessors methods
    */
   //Getter method
   get Passive() {
       return this.passive + " This is the pokemon Passive!";
   }

   //Setter method
   set Passive(passive:string) {
        this.passive = passive;
   }
}

let pika:Electric = new Electric();

//In Java, you would write pika.setPassive("Static body")
pika.Passive = "Static body";
//In Java, you would have to write console.log(pika.getPassive());
console.log(pika.Passive);