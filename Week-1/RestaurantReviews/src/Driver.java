import java.util.Scanner;

import com.revature.restrev.exceptions.InvalidRatingException;
import com.revature.restrev.models.Restaurant;
import com.revature.restrev.ui.Menu;
import com.revature.restrev.util.Logger;
import com.revature.restrev.util.Logger.LogLevel;

public class Driver {
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
		Menu.presentMenu();
	}

}
