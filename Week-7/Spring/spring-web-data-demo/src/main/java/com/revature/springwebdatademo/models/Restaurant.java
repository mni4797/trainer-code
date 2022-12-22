package com.revature.springwebdatademo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

// By default without the name attribute, hibernate infers that this table in the db is called restaurant
@Entity(name = "restaurants") // this class has a corresponding table in db called restaurants
public class Restaurant {
    @Id // this field is equivalent to the pk in db
    @GeneratedValue(strategy = GenerationType.IDENTITY) // telling orm that this field has a generated value, don't set
                                                        // it
    private int id;
    // annotation not necessary, ORM will see this and assume a column called name
    // exists in the table restaurant
    private String name;
    @Transient
    private double averageRating; // for the average rating we want to calculate this every time we get a
                                  // restaurant from the db
                                  // We're not saving average rating and @Transient tells the ORM that

    // fetch type eager means that every time I get a restaurant, include the
    // related reviews
    // The mappedBy property is what we use to tell Hibernate which variable/field
    // we are
    // using to represent the parent class in our child class.
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentRestaurant")
    private List<Review> reviews;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Restaurant [averageRating=" + averageRating + ", id=" + id + ", name=" + name + "]";
    }

}
