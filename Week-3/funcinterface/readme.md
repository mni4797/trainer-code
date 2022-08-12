# Functional Interface
* It an interface that have one abstract method
* Also called SAM (Single Abstract Method)
* It is utilized to create lambda expression
    * () -> {}
* Overall, they make our code cleaner and easier to follow
* Fun fact, method vs. function?
    * method - a member of a class
    * function - doesn't belong to a class
    * Variable vs Field
    * Variable - doesn't belong to a class
    * Field - a member to a class

## Pre-made functional interfaces given by Java
* Supplier\<T> Interface
    * Represents a function which doesn't take any parameters but returns something
    * get() is the SAM (Single Abstract Method)
    * It is similar to our FunctionalInterface2 except it is generic
* Consumer\<T> Interface
    * Represents a function which takes only a **single** parameter and doesn't return anything
    * accept() is the SAM
    * It is similar to our FunctionalInterface3 except it is generic
* Predicate Interface
    * Represents a funciton which gives a boolean result given one parameter
    * TLDR: if you come across amking alamda that takes one parameter and returns a boolean then use a Predicate
    * Useful for unit testing

# Streams API
* It is used to process a collection of objects

