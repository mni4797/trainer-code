import java.util.Scanner;

import com.revature.restrev.exceptions.InvalidRatingException;
import com.revature.restrev.models.Restaurant;
import com.revature.restrev.util.Logger;
import com.revature.restrev.util.Logger.LogLevel;

public class Driver {
	private static Logger logger= new Logger();
	//public - access modifier, any other class can access it and call it 
	// static - Object of the driver class need not be instantiated to utilize and execute this
	//			method
	// void - return type that states the method doesn't return anything
	// main - name of the method
	// String[] - string array
	// args - a method variable that contains reference to the string array
	public static void main(String[] args) {
		// for any method you have a general structure:
			// [access modifier] [non-access modifier] [return type] [method name] (arguments/paremeters)
		System.out.println("Hello World!");
		// Switch statement for options to decide what to do depending on the input
		// each case tells you what to do depending on different input
		// while loop, when they click on exit they could exit the while loop
		String userInput = "";
		// Scanner is a class that we'll use to read the console to get user input
		// lhs Scanner - Scanner class, reference type
		// lhs scanner - name for the reference 
		// rhs new - instantiates a new object of the type that is listed
		// rhs Scanner(System.in) - Parameterized constructor for the Scanner class that
		// takes in an input stream 
		Scanner scanner = new Scanner(System.in);
		
		//actual menu
		// while the userInput is not "x" we loop/ we present the menu again
		do {
			System.out.println("Welcome to my restaurant reviews application! An amateur foodie destination tracker");
			System.out.println("What would you like to do today?");
			System.out.println("[1] See that welcome message again");
			System.out.println("[2] Create Restaurant");
			System.out.println("[x] Exit out");
			// get user input using scanner
			userInput = scanner.nextLine();
			// switch user input based on user choice
			switch (userInput) {
			case "1":
				System.out.println("Hello World!");
				break;
			case "2":
				// create a restaurant
				
				Restaurant newRestaurant = new Restaurant();
				System.out.println("What's the restaurant name?");
				newRestaurant.name = scanner.nextLine();
				System.out.println("City?");
				newRestaurant.setCity(scanner.nextLine());
				System.out.println("State?");
				newRestaurant.setState(scanner.nextLine());
				System.out.println("How would you rate the restaurant out of 5?");
				try {
					newRestaurant.setRating(scanner.nextInt());
					scanner.nextLine();
				} catch (InvalidRatingException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println("Describe your dining experience");
				newRestaurant.description = scanner.nextLine();
				System.out.println(newRestaurant);
				break;
			case "x":
				System.out.println("Goodbye cruel world...");
				break;
			default: 
				logger.log(LogLevel.warning,"Invalid input");
				System.out.println("Wrong input. try again and choose a valid option this time. or else...");
				break;
			}
		} while(!(userInput.equals("x")));
		
	}

}
