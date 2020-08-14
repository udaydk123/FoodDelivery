package com.food.online.FoodDelivery.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.food.online.FoodDelivery.model.Restaurants;

@Validated
public interface RestaurantService {
	
	
	Restaurants save(Restaurants product);
	
	@NotNull Iterable<Restaurants> getAllRestaurants();

	Restaurants create(@NotNull(message = "The order cannot be null.") @Valid Restaurants restaurants);

    void update(@NotNull(message = "The order cannot be null.") @Valid Restaurants restaurants);
    
    void delete(@NotNull(message = "The order cannot be null.") @Valid Restaurants restaurants);
    
    
	


}
