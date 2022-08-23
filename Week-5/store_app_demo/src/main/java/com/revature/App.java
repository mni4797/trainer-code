package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.models.Customer;

/**
 * Driver class
 */
public final class App {
    private App() {
    }

    /**
     * Main method. Beginning of execution
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        System.out.println("Hello World!");
        // How to add a customer:
        // 1. asking the user for customer info
        // 2. connect to the db
        // 3. add info we need for the customer

        // ========= Add Customer Feature =============
        getCustomerInformation();
        System.out.println("Goodbye cruel world");

        // ======================================================
        // TODO: try implementing search customer functionality
        // =====================================================
    }

    /**
     * UI component for interacting with end user to get customer info to be added
     */
    private static void getCustomerInformation() {
        System.out.println("Executing get customer info method");
        // Asking the end user for customer info
        // Goal: Interact with end user get their idea of what info
        // should be added
        // 1. Present your prompt to the customer with sysout
        // 2. Get user input with scanner

        // Scanner
        // Functionality: reads from an input source
        // For our particular program, read info from console
        // System.in represents the input source
        // We're saying that the scanner is reading the console
        Scanner scanner = new Scanner(System.in);

        // getting the customer information
        System.out.println("What's your first name? ");
        String firstName = scanner.nextLine();

        System.out.println("What's your last name? ");
        String lastName = scanner.nextLine();

        System.out.println("What's your email? ");
        String email = scanner.nextLine();

        System.out.println("What's your password? ");
        String password = scanner.nextLine();

        // creating a customer object to hold all the data I've
        // farmed from the end user
        Customer newCustomer = new Customer();
        // newCustomer.getfName(); // null
        newCustomer.setfName(firstName);
        // newCustomer.getfName(); // whatever value firstName has
        newCustomer.setlName(lastName);
        newCustomer.setEmail(email);
        newCustomer.setPassword(password);
        addCustomer(newCustomer);
        scanner.close();
        System.out.println("Customer successfully added");
        System.out.println("get customer info method finished executing");
    }

    // pass information we're sourcing using another method
    /**
     * Add customer to DB by passing in values for each of the columns on the
     * customers table
     * 
     * @param customer
     */
    private static void addCustomer(Customer customer) {
        // ======================================================================
        // TODO: edit parameters and logic to work with Customer object instead
        // ======================================================================
        System.out.println("Executing add customer method");
        // Add to the DB info we got from end user
        // Goal: Add a new customer
        // How do we do insert
        // try with resources block
        // whatever we are instantiating in this try we close after we're done
        try (Connection connection = getConnection()) {

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
