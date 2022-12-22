package com.example;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.models.Restaurant;
import com.example.services.RestaurantService;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("Creating bean container");
        try (AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) {
            System.out.println("Container created");

            RestaurantService restaurantService = container.getBean(RestaurantService.class);
            List<Restaurant> allrestos = restaurantService.getAllRestaurants();

            System.out.println("Printing out all restaurants");
            for (Restaurant restaurant : allrestos) {
                System.out.println(restaurant.getId() + "\t" + restaurant.getName());
            }

        }
    }
}
