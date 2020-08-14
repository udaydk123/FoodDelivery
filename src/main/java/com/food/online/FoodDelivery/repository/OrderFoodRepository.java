package com.food.online.FoodDelivery.repository;
import org.springframework.data.repository.CrudRepository;

import com.food.online.FoodDelivery.model.OrderFood;
import com.food.online.FoodDelivery.model.OrderFoodPK;



public interface OrderFoodRepository extends CrudRepository<OrderFood, OrderFoodPK> {
}