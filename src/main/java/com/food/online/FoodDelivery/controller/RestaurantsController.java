package com.food.online.FoodDelivery.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.online.FoodDelivery.model.Restaurants;
import com.food.online.FoodDelivery.service.RestaurantService;

@RestController
@RequestMapping("/online/restaurants")
public class RestaurantsController {

    private RestaurantService restaurantsService;

    public RestaurantsController(RestaurantService restaurantService) {
        this.restaurantsService = restaurantService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Restaurants> getRestaurants() {
        return restaurantsService.getAllRestaurants();
    }  
}