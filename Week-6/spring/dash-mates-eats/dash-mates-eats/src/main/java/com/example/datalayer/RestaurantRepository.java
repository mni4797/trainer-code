package com.example.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Restaurant;
import com.example.utils.ConnectionFactory;

/**
 * @Repository is a stereotype annotation (specialization of plain component)
 *             that tells spring this is a class that works
 *             with the db
 */
@Repository
public class RestaurantRepository {
    @Autowired
    private ConnectionFactory connectionFactory;

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection()) {
            String query = "select * from restaurants";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                restaurants.add(
                        new Restaurant(
                                rs.getInt("id"),
                                rs.getString("restaurant_name")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurants;
    }
}
