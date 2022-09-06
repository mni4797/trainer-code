package com.revature.springwebdatademo.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.springwebdatademo.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    // Spring Data automatically generates the DAO Impl class of this interface and
    // all crud methods
    // .save(), .delete(), .update()
    /**
     * Property Expressions in Spring (look in Spring documentation about this)
     * 
     * Spring Data JPA will examine all the properties of the class that corresponds
     * to this repository and INFER SQL STATEMENTS based on the direct properties of
     * the class.
     * 
     */
    public Optional<Restaurant> findByName(String name);// Select * from restaurants where name = ?
}
