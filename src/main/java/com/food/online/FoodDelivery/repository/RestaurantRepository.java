package com.food.online.FoodDelivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.online.FoodDelivery.model.Restaurants;

public interface RestaurantRepository extends  CrudRepository<Restaurants, Long> {

}
