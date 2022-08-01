package com.revature.restrev.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.restrev.exceptions.InvalidRatingException;

class RestaurantTest {

	@Test // this annotation tells the compiler that this is a junit test
	void setRatingShouldSet(){
		// Arrange
		// create a dummy restaurant
		Restaurant test = new Restaurant();
		// initialize a test value for the rating
		int testRating = 3;

		// Act
		// Set the rating
		test.setRating(testRating);

		// Assert
		// Assert that the expected rating value is the same as the actual rating
		assertEquals(testRating, test.getRating());

	}

	@Test
	void setRatingShouldThrowException() {
		// Arrange
		// create a dummy restaurant
		Restaurant test = new Restaurant();
		// initialize a test value for the rating
		int testRating = 6;

		// Act & Assert
		// assert that setting the rating with an invalid value results in an exception
		// being thrown
		assertThrows(InvalidRatingException.class, () -> test.setRating(testRating));
	}

}
