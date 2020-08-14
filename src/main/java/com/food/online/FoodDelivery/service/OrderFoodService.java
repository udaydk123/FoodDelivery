package com.food.online.FoodDelivery.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.food.online.FoodDelivery.model.OrderFood;

@Validated
public interface OrderFoodService {

    OrderFood create(@NotNull(message = "The food for order cannot be null.") @Valid OrderFood orderfood);
}