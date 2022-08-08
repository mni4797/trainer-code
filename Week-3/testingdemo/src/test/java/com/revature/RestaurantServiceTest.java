package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.data.DAO;
import com.revature.models.Restaurant;
import com.revature.models.Review;
import com.revature.service.RestaurantService;

public class RestaurantServiceTest {
    // what I'll be mocking
    private DAO<Restaurant, Integer> restaurantDAO;
    private RestaurantService rService;

    // run this before each test method
    @BeforeEach
    public void setup() {
        restaurantDAO = Mockito.mock(DAO.class);
        rService = new RestaurantService(restaurantDAO);
    }

    @Test
    public void getRestaurantById_Should_Calculate_Average() {
        // Arrange
        Restaurant tRestaurant = new Restaurant(1, "Applebee's");
        ArrayList<Review> reviews = new ArrayList<Review>() {
            {
                add(new Review(1, 5, "They have a good quesadilla burger"));
                add(new Review(2, 5, "They have good customer service"));
            }
        };
        tRestaurant.setReviews(reviews);

        // arrange behavior of stub
        // when you call the method getInstance by id in the stub, return this dummy
        // result
        when(restaurantDAO.getInstanceById(anyInt())).thenReturn(tRestaurant);

        // Act
        Restaurant resultRestaurant = rService.getRestaurantById(1);
        // Assert
        assertEquals(resultRestaurant.getAvgRating(), 5);
    }
}
