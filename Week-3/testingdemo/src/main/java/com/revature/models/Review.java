package com.revature.models;

/***
 * POJO for review for a restaurant
 * 
 * @author
 ***/
public class Review {
    private int id;
    private int rating;
    private String description;

    public Review(int id, int rating, String description) {
        this.id = id;
        this.rating = rating;
        this.description = description;
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
