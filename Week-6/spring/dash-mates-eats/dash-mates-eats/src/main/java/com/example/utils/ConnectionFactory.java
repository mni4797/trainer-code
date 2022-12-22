package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component is a class level annotation that tells spring to handle object
 *            creation of this class
 * 
 */
@Component
public class ConnectionFactory {
    private Connection connection;
    // property injection from the dbProps file
    @Value("${db.url}")
    private String db_url;
    @Value("${db.username}")
    private String db_user;
    @Value("${db.password}")
    private String db_password;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Set up DB credentials for my DB
                // note that the url has a certain syntax

                try {
                    // Create a connection to the DB using creds
                    connection = DriverManager.getConnection(db_url, db_user, db_password);
                    System.out.println("finishing executiong of get connection");
                    return connection;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
