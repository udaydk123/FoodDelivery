package com.food.online.FoodDelivery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.food.online.FoodDelivery.model.Restaurants;
import com.food.online.FoodDelivery.service.RestaurantService;

@SpringBootApplication
public class FoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApplication.class, args);
	}

	  @Bean
	    CommandLineRunner runner(RestaurantService restaurantService) {
	        return args -> {
	        	restaurantService.save(new Restaurants(1L, "Restaurants1","location1", 
	        			4, "http://localhost/200x100", true, false));
	        	restaurantService.save(new Restaurants(2L, "Restaurants2","location2", 
	        			4, "http://localhost/200x100", true, false));
	        	restaurantService.save(new Restaurants(3L, "Restaurants3","location3", 
	        			3, "http://localhost/200x100", true, true));
	        	restaurantService.save(new Restaurants(4L, "Restaurants4","location4", 
	        			2, "http://localhost/200x100", false, false));
	        	restaurantService.save(new Restaurants(5L, "Restaurants5","location5", 
	        			1, "http://localhost/200x100", true, false));
	        	restaurantService.save(new Restaurants(6L, "Restaurants6","location1", 
	        			5, "http://localhost/200x100", true, true));
	        	restaurantService.save(new Restaurants(7L, "Restaurants7","location2", 
	        			4, "http://localhost/200x100", true, false));
	        };
	    }

}
