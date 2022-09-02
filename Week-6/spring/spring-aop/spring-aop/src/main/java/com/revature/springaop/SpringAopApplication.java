package com.revature.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.springaop.services.SomerService;

@SpringBootApplication // combines 3 annotations @Configuration, @ComponentScan,
						// @EnableAutoConfiguration - annotations you use to set up your bean container
public class SpringAopApplication implements CommandLineRunner {
	@Autowired
	private SomerService service;

	public static void main(String[] args) {
		/**
		 * SpringApplication.run boostraps (self starts) the application
		 * 
		 * .run() also creates an application context instance and loads beans
		 * that are marked with @Component and/or other Stereotype annotations like
		 * @service, @repository, etc
		 * 
		 * IF you have the spring web starter dependency, then it also starts
		 * the embedded tomcat server by default on port 8080 (this setting can
		 * be changed in your appication.properties file)
		 */
		SpringApplication.run(SpringAopApplication.class, args);
	}

	/**
	 * Since we have implemented the CommandLineRunner interface,
	 * we'll run the following logic inside of this method INSTEAD OF launching
	 * some embedded Tomcat server and running the app there.
	 */
	@Override
	public void run(String... args) throws Exception {
		// add the demo logic here laters
		System.out.println(service.getSomething());
	}

}
