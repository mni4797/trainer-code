package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.daos.OrderDAO;
import com.revature.daos.ProductDAO;
import com.revature.models.Customer;
import com.revature.models.LineItem;
import com.revature.models.Order;
import com.revature.models.Product;

/**
 * Driver class
 */
public final class App {
    // Giving the scanner class wide scope so we can use it in other methods
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerDAO customerDao = new CustomerDAO();
    private static final ProductDAO productDao = new ProductDAO();
    private static final OrderDAO orderDao = new OrderDAO();

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
        // searchCustomer();

        // ============ Show products ==========
        // showProducts();

        // ============ Shop ==================
        shop();
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
        // Placing order functionality
        // ===============================================
        // Search customer
        // list of product,
        // select products to add to cart,
        // do the checkout

    }

    // implementation of order functionality
    private static void shop() {
        // Search for customer to shop for
        Customer shoppingCustomer = searchCustomer();

        // cart represents the products we want to buy
        // edit the cart so that it holds products and quantity
        // (aka lineItems)
        // instead of just products
        List<LineItem> cart = new ArrayList<>();
        // inventory represents the products in our DB that is on sale
        List<Product> inventory = productDao.getAllProducts();
        // userInput represents the action user chooses
        String userInput = "";
        while (userInput != "checkout") {
            // show products
            // based off of the indexing of lists wherein the first element has an index of
            // 0
            int index = 0;
            for (Product product : inventory) {
                // use index to identify the location of a product object in the list
                System.out.println(index + " " + product.getName() + "\t" + product.getPrice());
                index++;
            }

            System.out.println("Would you like to add a product to cart?");
            System.out.println("Enter index # if yes if not enter -1: ");
            // add products to cart
            userInput = scanner.nextLine();
            try {
                // with the end user's chosen product, use it's index to indentify which
                // product to add to cart
                int productIndex = Integer.parseInt(userInput);
                if (productIndex > -1) {
                    Product add2Cart = inventory.get(productIndex);
                    // How to ask end user for amount of product
                    System.out.println("How many would like of this item?");
                    int quantity = scanner.nextInt();
                    // I need to move the scanner cursor to the next line
                    // because nextInt() doesn't do that
                    // and my program will behave weirdly otherwise
                    scanner.nextLine();
                    // Create lineItem object to hold the info of the product we want
                    // and how much of that product we want
                    LineItem lineItem = new LineItem();
                    // Note that the product and quantity
                    // are properties of our lineItem class
                    // set how much of that product we are buying
                    lineItem.setQuantity(quantity);
                    // set which product we are buying
                    lineItem.setProduct(add2Cart);
                    cart.add(lineItem);
                } else
                    userInput = "checkout";
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Product out of bounds");
            }
        }
        // variable to store orderTotal
        double total = 0;
        for (LineItem lineItem : cart) {
            // to access properties of an object that belongs to another object
            // EX: accessing the name of the Product object that belongs
            // to a line item object, you just have to chain your
            // dot (.) operators

            // Let's unpack lineItem.getProduct().getName()
            // lineItem.getProduct() returns a Product object
            // we know that the product object has a name property
            // To get the name property of a product object we invoke
            // the getName()
            // lineItem.getProduct() => some Product object
            // some Product object.getName() => returns product name
            Product product = lineItem.getProduct();
            System.out.println(product.getName() + "\t" + product.getPrice() + "\t" + lineItem.getQuantity());
            // Total = how much a product multiplied by the price of the product
            total += product.getPrice() * lineItem.getQuantity();
        }
        // print total
        System.out.println("Total: " + total);
        // checkout the products
        Order newOrder = new Order();
        newOrder.setCustomer_id(shoppingCustomer.getId());
        newOrder.setTotal(total);
        newOrder.setLineItems(cart);
        orderDao.addOrder(newOrder);

    }

    private static void showProducts() {
        System.out.println("List of products");
        // create a product DAO object

        // productDao.getAllProducts returns a list of products
        // "catching" the list of products the DAO is returning
        List<Product> productsFromDB = productDao.getAllProducts();
        // foreach loop => perfect for iterating over a list
        for (Product product : productsFromDB) {
            System.out.println(product);
        }
        // The above foreach loop is equivalent to the below for loop
        // for (int i = 0; i < productsFromDB.size(); i++) {
        // Product product = productsFromDB.get(i);
        // System.out.println(product);
        // }

    }

    /*
     * returns the Customer object found
     */
    private static Customer searchCustomer() {
        // ask user for customer email
        System.out.println("Please enter email of customer: ");
        String email = scanner.nextLine();
        // call dao to get customer with matching email
        Customer filteredCustomer = customerDao.getCustomerByEmail(email);
        // logic for printing out customer info
        if (filteredCustomer == null)
            System.out.println("No customer found with that email :<");
        else {
            System.out.println(filteredCustomer);
        }
        return filteredCustomer;
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
