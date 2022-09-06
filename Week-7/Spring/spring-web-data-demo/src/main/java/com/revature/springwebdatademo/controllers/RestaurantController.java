package com.revature.springwebdatademo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springwebdatademo.models.Restaurant;
import com.revature.springwebdatademo.services.RestaurantService;

@RestController // All methods in the class will return an HTTP response
@RequestMapping("/restaurants") // all methods are available at http:/locahost:5000/restaurants
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping // get request to http://localhost:5000/restaurants
    public List<Restaurant> sendAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}") // get request to http://localhost:5000/restaurants/{id}
    public Restaurant sendRestaurantWithId(@PathVariable String id) {
        Optional<Restaurant> rOptional = restaurantService.getRestaurantById(Integer.parseInt(id));
        if (rOptional.isPresent()) {
            return rOptional.get();
        } else {
            return new Restaurant("No restaurant found with id " + id);
        }
    }

    @PostMapping // post request to http://localhost:5000/restaurants
    public Restaurant createRestaurant(@RequestBody Restaurant newRestaurant) {
        return restaurantService.addRestaurant(newRestaurant);
    }

}
