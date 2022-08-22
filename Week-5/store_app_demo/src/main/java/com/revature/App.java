package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

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

    }

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

        // ================================================================
        // TODO combine all properties in a customer object
        // TODO: pass customer object as parameter to addCustomer method instead
        // ================================================================

        addCustomer(firstName, lastName, email, password);
        System.out.println("Customer successfully added");
        System.out.println("get customer info method finished executing");
    }

    private static Connection getConnection() {
        System.out.println("executing get connection method");
        // Connecting to the DB
        // Goal: Connect to DB, you connect to it the same way for all
        // your DB fcnality
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

        // First we load up the postgresql Driver
        // Our way of telling JDBC to use this particular implementation
        // to interact with DB
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // Set up DB credentials for my DB
        // note that the url has a certain syntax
        String db_url = "jdbc:postgresql://javareact-220725-trainingdb.cvtq9j4axrge.us-east-1.rds.amazonaws.com:5432/postgres";
        String db_user = "mars";
        String db_password = "P455w0rd";
        try {
            // Create a connection to the DB using creds
            Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("finishing executiong of get connection");
            return connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // pass information we're sourcing using another method
    private static void addCustomer(String firstName, String lastName, String email, String password) {
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
            pstmt.setString(1, firstName);
            // pstmt.setString(2, lastName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, password);

            // execute query
            pstmt.executeUpdate();
            System.out.println("finishing executing add customer method");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
