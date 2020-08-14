package com.food.online.FoodDelivery.repository;
import org.springframework.data.repository.CrudRepository;

import com.food.online.FoodDelivery.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}