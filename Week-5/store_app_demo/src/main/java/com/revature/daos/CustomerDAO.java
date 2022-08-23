package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Customer;
import com.revature.utils.dao.ConnectionFactory;

// DAO - Data Access Object
// Design pattern for creating classes that interact with DB or some
// other data storage system
// Usually you make a DAO for each table you have in the DB
// Methods in a DAO usually cover common interactions with DB
// DAO would be a collection of methods that interact with DB

/**
 * DAO for customers.
 * Used in interacting with customers table in my db
 */
public class CustomerDAO {
    // Methods in a CustomerDAO
    // addCustomer = for adding a customer
    // search customer by email
    // search customer by id
    // get all customers

    // pass information we're sourcing using another method
    // Access modifiers:
    // Dilemma:
    // When I copy pasted this code from the App.java class
    // I did everything right, because it was in another class
    // to access this method, I created a new instance/ an object
    // of the customerDAO but when I tried to access this method
    // when it still had the method sig of:
    // private static void addCustomer(Customer customer)
    // App.java was giving me red squigglies (i.e syntax errors)

    // Solution 1: remove the static keyword = did not help
    // Solution 2: remove private keyword = did not help
    // Solution 3: add in public keyword = worked!

    // Access modifiers: public, private, protected, default
    // public - this method/field/class is accessible to other classes
    // whether they're in the same package or the class trying to access it
    // is a subclass of that class
    // private - this method/field is accessible only within the class
    // it is declared in
    // protected - this method/field is accessible for subclasses of this class
    // default (ie if you didn't explicitly state an access modifier)
    // - this method/field/class is accessible only within the package

    //
    /**
     * Add customer to DB by passing in values for each of the columns on the
     * customers table
     * 
     * @param customer
     */
    public void addCustomer(Customer customer) {
        // ======================================================================
        // TODO: edit parameters and logic to work with Customer object instead
        // ======================================================================
        System.out.println("Executing add customer method in class CustomerDAO");
        // Add to the DB info we got from end user
        // Goal: Add a new customer
        // How do we do insert
        // try with resources block
        // whatever we are instantiating in this try we close after we're done
        try (Connection connection = ConnectionFactory.getConnection()) {

            // Start with String query
            // we tell it what we want it to do, in the way we do it in sql
            // column names must match whatever we have on table in DB
            String query = "insert into customers (first_name, last_name, email, customer_password) values (?,?,?,?)";
            // Statement we will be executing against the DB
            PreparedStatement pstmt = connection.prepareStatement(query);

            // Set the parameters of our query
            // for a parameter in your query
            // you convert that java string into a sql VARCHAR
            pstmt.setString(1, customer.getfName());
            // pstmt.setString(2, lastName);
            pstmt.setString(2, customer.getlName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getPassword());

            // execute query
            pstmt.executeUpdate();
            System.out.println("finishing executing add customer method");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
