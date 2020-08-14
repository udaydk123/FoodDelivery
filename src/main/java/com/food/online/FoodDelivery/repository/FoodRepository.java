package com.food.online.FoodDelivery.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.online.FoodDelivery.model.FoodMenuItems;

public interface FoodRepository extends CrudRepository<FoodMenuItems, Long> {
}