# Linked List

- store elements in nodes
- Whenever you add to a linked list, you add another node
- nodes are compromised of the data it holds, and a pointer to the next node in the list, if a node points to nothing, that is the last node of the list
- to traverse a linked list, you have to go through each and every node

## Methods:

1. void addNode(T data) - adds a node to the end of the list
2. void printList() - traverses through the linked list and prints out the values of each node

## Fields:

1. Node<T> head - gives you the starting point or head of linked list, so you know where to begin traversing
2. Node<T> tail - gives you the current last element of the linked list (optional)

# Node

- where you store elements in a linkedlist, stack, queue, tree, etc

## Fields

1. T data - the actual data stored in the Node
2. Node<T> next - the adjacent node
