package com.revature.utils;

import com.revature.utils.Dequeue.Node;

public class Dequeue<E> {

    private Node<E> first;
    private Node<E> last;

    public Dequeue(){
        this.first = null;
        this.last = null;
    }

    //Will add an element to the first
    public void addFirst(E element){
        Node newNode = new Node(element);

        //and first next is null
        if (this.first == null) {
            this.first = newNode;
            this.last = newNode;
        }else {
            //Makes the newNode point to the current first node
            newNode.setNext(this.first);

            //Makes the current first node point to the new node
            this.first.setLast(newNode);

            //Sets our first pointer
            this.first = newNode;
        }
    }

    //This will take the first node and grab its data as well as remove it from our collection
    public E pollFirst(){

        //In the case that the collection is empty, return nothing
        if (this.first == null) 
        {
            return null;
        }
        //In case there is only one node left, go ahead and set the pointers to point at nothing
        else if (first.getNext() == null){
            E data = this.first.getData();

            this.first = null;
            this.last = null;

            return data;
        }   

        //Grabs the information from the first node and store it
        Node<E> newNode = this.first;

        //Grabs the previous Node of the first node and sets the last point of it to null
        newNode.getNext().setLast(null);

        //Sets our first pointer to the previous node
        this.first = newNode.getNext();

        //Remove the pointer
        newNode.setNext(null);

        return newNode.getData();
    }

    public void addLast(E element) {
	   	 Node newNode = new Node(element);
	
	     if (this.last == null) {
	         this.last = newNode;
	         this.first = newNode;
	     }else {
	         newNode.setLast(this.last);
	
	         this.last.setNext(newNode);
	
	         this.last = newNode;
	     }
    }

    public E pollLast(){
	   	 if (this.last == null) 
		        {
		            return null;
		        }
		        else if (last.getLast() == null){
		            E data = this.last.getData();
	
		            this.first = null;
		            this.last = null;
	
		            return data;
		        }   
	
		        Node<E> newNode = this.last;
	
		        newNode.getLast().setNext(null);
	
		        this.last = newNode.getLast();
	
		        newNode.setLast(null);
	
		        return newNode.getData();
    }
    
    //Node class to hold our data and pointers
    public class Node<E>{

        private Node<E> next;
        private Node<E> last;
        private E data;

        public Node(){
            this.next = null;
            this.last = null;
            this.data = null;
        }

        public Node(E data) {
            this();
            this.data = data;
        }
        
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public Node<E> getLast() {
            return last;
        }
        public void setLast(Node<E> last) {
            this.last = last;
        }
        public E getData() {
            return data;
        }
        public void setData(E data) {
            this.data = data;
        }

        
    }
}
