# Introduction JavaScript
* Best way to make your website dynamically changed
* Dynamic & weakly typed
    * It assigns datatypes during the runtime/execution of your program
    * Variables are not attached to a datatype, meaning you can have a variable change its datatype with no exceptions
* It is an interpreted programming language
    * It reads your source code line by line and then feed that to an interperter which then spits our machine code
    * Interpreted programming language is slower than compiled language due to the extra step of interpreting line by line and then converting to machine code
* It is both a functional and object-oriented programming language
    * Functional means we can make functions and only use functions (if you want to)
    * Ever since EcmaScript6, introduced classes which made it an object-oriented programming
* Another thing with JavaScript is that it can be run in multiple places:
    * Unlike Java in which you must have a JVM to run the app
    * Can be run on Chrome v8, Firefox SpiderMonkey, Nodejs

## JavaScript Engine
* Example of JS engine is Chrome v8
* JS still goes through an interpreter and converts your code line by line into bytecode.
* To solve this inefficiency, this is where the engine compiles your JS source code instead
* Using some feedback loop after executing your code, Chrome engine will detect certain patterns and compile that part of your code into machine code! No longer going through the need of an interpreter
* This special compiler is called **Just-In-Time compiler** (JIT compiler)

## Datatypes of JS
* Primitives:
    * Numbers - hold any number (numerical or decimal)
    * Boolean
    * Strings
    * Null - lack of value meaning this variable doesn't have any information at the moment
    * Undefined -no value was ever set to that variable
* Reference:
    * Objects
    * Functions
    * Arrays

## Classes
* Has most of the OOP pillars we discussed and implements them easily except abstraction

## Truthy and Falsey
* FUN0NE
* False - False
* Undefined - false
* Null - false
* +0, -0 - false
* NaN - false
* Empty String - false
* Everything else will be true


