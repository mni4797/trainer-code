package com.revature.restrev.exceptions;

public class InvalidRatingException extends RuntimeException{
	public InvalidRatingException(String message) {
		// call parent constructor 
		super(message);
	}
}
