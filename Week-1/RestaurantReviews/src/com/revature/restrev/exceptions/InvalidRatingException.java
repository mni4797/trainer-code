package com.revature.restrev.exceptions;

// prime example of inheritance 
public class InvalidRatingException extends RuntimeException{
	public InvalidRatingException(String message) {
		// call parent constructor 
		super(message);
	}
}
