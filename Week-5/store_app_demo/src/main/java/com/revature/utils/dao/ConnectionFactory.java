package com.revature.utils.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * This is meant to create a connection to the db
 */
public class ConnectionFactory {
    // will have that one method == getConnection
    private static Connection connection;

    // First things first, make sure that your postgreSQL driver is
    // included in your pom.xml file as a dependency
    // It's the postrgreSQL driver that contains the actual logic
    // needed by our program to work with Postgres
    // JDBC is a collection of interfaces that describe behavior
    // needed to work with a DB from our Java code
    // Interfaces don't contain actaul logic, they usually contain
    // method stubs aka they are abstract aka interfaces don't
    // have actual logic
    // Postgresql Driver that we add as the dependency contains the
    // implementation details needed to work with a Postgres DB
    // It's a postgres specific implementation of the JDBC

    // static is a keyword, static methods/fields belong to the class
    // not instances of the class, all instances of a class
    // share the value of a static field, you don't have to
    // instantiate a class to access the static method

    // Static block
    // gets executed at program startup
    // This block gets executed first
    // TLDR when we run the app, we first load the postgreSQL Driver
    static {
        // First we load up the postgresql Driver
        // Our way of telling JDBC to use this particular implementation
        // to interact with DB
        try {
            System.out.println("Loading driver we are in ConnectionFactory");
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Method for connecting to DB
     * 
     * @return Connection to Db
     */
    public static Connection getConnection() {
        System.out.println("executing get connection method in class ConnectionFactory");
        // Connecting to the DB
        // Goal: Connect to DB, you connect to it the same way for all
        // your DB fcnality

        // Check if connection is null or closed = no live connection to DB
        try {
            if (connection == null || connection.isClosed()) {
                // Set up DB credentials for my DB
                // note that the url has a certain syntax
                String db_url = "jdbc:postgresql://javareact-220725-trainingdb.cvtq9j4axrge.us-east-1.rds.amazonaws.com:5432/postgres";
                String db_user = "mars";
                String db_password = "P455w0rd";
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
