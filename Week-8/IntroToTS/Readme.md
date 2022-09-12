# Node.js
* It is a free and open-source JS interpreter that allows us to run JS outside of a web browser
* Platform independent
    * It can run on any OS you want
* Uses Google's chrome V8 engine

## Node Package Manager (NPM)
* It is similar to Maven, it can manage your dependencies and also grab them from the internet
* But unlike using pom.xml, it uses package.json file
* It will also store all of our dependenices in a folder called **node_modules**

# TypeScript (TS)
* It is an open-source langauge developed by Microsoft
* It object-oriented programming language and functional programming language
* It is **strongly typed** / strictly typed
* It is **superset** of JavaScript
    * All this means that TS has everything JS has but more

## Transpilation process
* Every browser (as of right now) does not support TS and can only run JS
* Transpilation is the process of converting our TS file into a JS file

## Datatype TS
* Everything from JS
* Any - Any datatype can be inputted in this variable
* Union - attaching multiple datatypes in a variable
* Tuple - Acts like an array but it has a fixed size and order of datatypes matter
* Enums - Works like a normal Enum in Java
* Never - Used for error handling (function/method will never give anything)
* Void - The function/method will give "nothing" 

## Access Modifiers
* public - Access everywhere
* protected - Access within the class and its subclasses
* private - Access only within the class

## Accessor Methods
* Use get keyword to create a get method
* Use set keyword to create a set method
* Used to complete encapsulation and now we have complete control of our data