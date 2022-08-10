# Dequeue Data Structure
* Represents a double ended queue
* Meaning you can add an element on the beginning of the queue or at the end of the queue
* Ex: Your browser function to be able to go back and forward on, undo functionality of an app, or if you want a stack and a queue in one single data structure.

# Iterable & Iterators
* It allows us to tell Java how we can iterate through our custom data structure we have made ourselves
* This gives our custom data structure capabilityes such as using a foreach statement
# Iterable Interface
* It is used by Java to indicate that this custom data structure can be used/targeted by a foreach statement
# Iterator Interface
* It is used by Java to indicate **how** we can actually iterate through the data structure
* It needs at least two methods from this interface to fully work
* next() - will return the current element and then go to the next element
* hasNext() - will check if there is even data left to iterate through

# Hashing
* Just some function or algorithm that makes a numerical representation of an object
* Ex: student id, ssn, phone number
* Numbers are just a lot easier to find information and hashing is how it transforms an object into numbers

# Collision Problems
* A problem when two or more objects have the same hash numerical representation
* To solve, it puts the two or more objects into a linked list
    * Fun fact, each linked list is called a bucket
* So overall, we filtered our elements into a few possible choices

## Examples of Java collections that uses hashing
* HashSet - Acts like a set
* HashMap - Acts like map (key/value pair)

# Comparable Interface
* It allows us to tell Java that I can compare my custom made class this way
    * Ex: student class and to compare two students I will use the grade field
* It is useful for sorting your collection
* You must implement compareTo() method that will dictact how can I compare this class to each other

## Comparator Interface
* It allows us to also compare an object with other possible fields it may have
* Also allows us to sort with other possible fields as well by indicating on the Collection.sort method
* It is a seperate class to compare by different fields members

# Anonymous class
* Allows you to both declare and instantiate an object from a class