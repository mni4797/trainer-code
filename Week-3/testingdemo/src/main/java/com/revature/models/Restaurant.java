package com.revature.models;

import java.util.ArrayList;

/***
 * POJO for restaurant
 * 
 * @author Marielle Nolasco
 ***/
public class Restaurant {
    private int id;
    private String name;
    private ArrayList<Review> reviews;
    private int avgRating;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

}