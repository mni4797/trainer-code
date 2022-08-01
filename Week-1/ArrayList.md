# Arraylist

- It's a data structure that stores elements in a dynamically sized array
- Uses arrays
- Indexbased type
- In Java, the default starting size of the array is 10 & it increases by 50% of the old size when resizing

## Implementation:

### Methods:

1. void addElement(T data) - add an element to the array
2. T getElementAtIndex(int Index) - get the element given the index
3. T[] resize(T[] oldArray) - internal helper method for dynamic sizing
4. T[] getAllElements() - returns all the elements of the arraylist
5. int getLength() - returns the length of arraylist

### Fields:

1. length - length of arraylist, count of all the elements in the arraylist
2. size - the actual size of arraylist including the empty slots
3. currentLastIndex - current end of your list
4. backingArray - contains the elements of your arrayList

Hints:

- Research how to create a generic class
- To start off, try and create a Arraylist that holds just ints and then work on making that class generic
