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