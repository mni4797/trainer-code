package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.datalayer.RestaurantRepository;
import com.example.models.Restaurant;

/**
 * @Service like @Repository this is also a stereotype annotation that tells
 *          spring this is a class that holds business logic
 */
@Service
public class RestaurantService {
    private RestaurantRepository repo;

    // If you're doing constructor injection, you don't need to use the @Autowire
    // annotation, spring does it automagically for you
    // autowire this
    public RestaurantService(RestaurantRepository repo) {
        this.repo = repo;
    }

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = repo.getAllRestaurants();
        return restaurants;
    }
}
