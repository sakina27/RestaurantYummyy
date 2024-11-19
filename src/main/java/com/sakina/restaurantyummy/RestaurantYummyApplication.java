package com.sakina.restaurantyummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication ( exclude = { SecurityAutoConfiguration.class})
public class RestaurantYummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantYummyApplication.class, args);
	}

}
