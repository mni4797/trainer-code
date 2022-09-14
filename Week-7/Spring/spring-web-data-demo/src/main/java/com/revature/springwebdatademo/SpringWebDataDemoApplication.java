package com.revature.springwebdatademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.revature.springwebdatademo.services.RestaurantService;

@SpringBootApplication
public class SpringWebDataDemoApplication {
	@Autowired
	private RestaurantService rService;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebDataDemoApplication.class, args);
	}

	// to configure CORS, just copy paste the below code
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// addMapping is for umbrella URLS
				// allowed origins is frontend url
				// For all our endpoints API side, respond to requests sent localhost:3000
				registry.addMapping("/**").allowedOrigins("http://localhost:3000", "http://localhost:3001");
				//
			}
		};
	}

}
