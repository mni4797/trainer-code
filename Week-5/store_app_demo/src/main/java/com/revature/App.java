package com.revature;

import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.models.Customer;

/**
 * Driver class
 */
public final class App {
    // Giving the scanner class wide scope so we can use it in other methods
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerDAO customerDao = new CustomerDAO();

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
        // insert into customers (first_name, last_name, email, password) values
        // ('Yazan', 'Deek', 'yazan.deek@gmail.com', 'anything')
        // 1. asking the user for customer info
        // 2. connect to the db
        // 3. add info we need for the customer

        // ========= Add Customer Feature =============
        // getCustomerInformation();

        // =========== Search Customer Feature =============
        searchCustomer();
        System.out.println("Goodbye cruel world");

        // ======================================================
        // Implementing search customer functionality
        // =====================================================
        // How to search for a customer by their email:
        // select from customers where email = 'yazan.deek@gmail.com'
        // 1. ask customer for their email
        // 2. connect to the db
        // 3. query db to find customer based on their email
        // 4. get the customer from the db with matching email
        // 5. Print out the customer details of the customer you found to the console

        // ===Ask customer for their email===
        // Class: App.java
        // create method for asking to the user which customer they want to search
        // based on the email
        // === Query DB to find customer based on their email ===
        // Class: CustomerDAO
        // create method for searching customer in DB by their email
        // parameters: string email
        // return type: Customer object based on value of email
        //

        // ===============================================
        // TODO create an orders table that relates to a products table
        // and the customers table
        // ===============================================

    }

    private static void searchCustomer() {
        // TODO finish logic for this method
        // ask user for customer email
        System.out.println("Please enter email of unknown customer: ");
        String email = scanner.nextLine();
        // call dao to get customer with matching email
        Customer filteredCustomer = customerDao.getCustomerByEmail(email);
        // logic for printing out customer info
        if (filteredCustomer == null)
            System.out.println("No customer found with that email :<");
        else {
            System.out.println(filteredCustomer);
        }
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

        customerDao.addCustomer(newCustomer);
        scanner.close();
        System.out.println("Customer successfully added");
        System.out.println("get customer info method finished executing");
    }

}
