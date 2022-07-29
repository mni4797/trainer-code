package com.revature.friday.lecture.demo;

//Make sure you import the Field class from the reflection!
//Any other field classes from other packages will fail
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// System.out.println("Hello World");

		// SoftwareEngineer eng1 = new SoftwareEngineer();

		// System.out.println(eng1.GiveNumber()*38.6);

		// Job job1 = new SoftwareEngineer();

		// job1.DoJob();

		System.out.println("Reflection DEMO");

		Car car1 = new Car(); 

		car1.setCost(10000);
		System.out.println(car1.getCost());

		car1.setCost(-10000);
		System.out.println(car1.getCost());
		
		//Reflection way
		//We grab the actual class itself
		Class carClass = Car.class; 

		//Checked exceptions forces us to put things in try catch if they throw the exceptions
		try {
			//We are grabbing the field cost
			Field costField = carClass.getDeclaredField("cost"); 
			costField.setAccessible(true);

			costField.set(car1, -3000);

			System.out.println(car1.getCost()); //What am I?
			// 0 - 2, -3000 - 1, -10000 - 1, 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Grabbing and display our fields
		Field[] allFields = carClass.getDeclaredFields();

		for (Field field : allFields) {
			System.out.println(field.getName());
		}

		//Clears our terminal screen
		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.println("Unit testing starting...");
		CarTest carTest = new CarTest();

		//Reflection selecting every method and running it
		Class carTestClass = CarTest.class;

		Method[] carTestMethods = carTestClass.getDeclaredMethods();

		//Foreach loop
		for (Method method : carTestMethods) {
			System.out.println(method.getName());

			try {
				//Grabs the return result of that method
				boolean result = (boolean)method.invoke(carTest);

				//Display Success/Failure depending on result
				if (result) 
				{
					System.out.println("Success");
				}
				else 
				{
					System.out.println("Failure");
				}
			} 
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
