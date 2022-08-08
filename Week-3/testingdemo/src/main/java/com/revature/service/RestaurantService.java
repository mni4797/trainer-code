package com.revature.service;

import com.revature.data.DAO;
import com.revature.models.Restaurant;
import com.revature.models.Review;

/***
 * Class containing logic to process restaurant objects
 * 
 * @author Marielle Nolasco
 */
public class RestaurantService {

    private DAO<Restaurant, Integer> restaurantDAO;

    // Constructor injection
    // injecting dependencies of class via the constructor
    public RestaurantService(DAO<Restaurant, Integer> rDao) {
        this.restaurantDAO = rDao;
    }

    public Restaurant getRestaurantById(int id) {
        // Todo implement method that calculates average rating of the restaurant given
        // reviews
        // Assuming that the DAO layer returns a restaurant with its associated reviews
        Restaurant fromDAO = restaurantDAO.getInstanceById(id);
        // to calculate average you sum the total ratings and divide by count of ratings
        int totalRating = 0;
        for (Review review : fromDAO.getReviews()) {
            totalRating += review.getRating();
        }
        fromDAO.setAvgRating(totalRating / fromDAO.getReviews().size());
        return fromDAO;
    }
}
