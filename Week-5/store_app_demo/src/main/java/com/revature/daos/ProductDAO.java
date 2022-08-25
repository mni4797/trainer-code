package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Product;
import com.revature.utils.dao.ConnectionFactory;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "select * from products";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {// while there's still results in the result set
                // we're unpacking the result set and adding new product objects to a list of
                // product objects
                products.add(new Product(rs.getInt("id"), rs.getString("product_name"), rs.getDouble("price")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }
}
