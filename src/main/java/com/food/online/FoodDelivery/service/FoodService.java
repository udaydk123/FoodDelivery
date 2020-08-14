package com.food.online.FoodDelivery.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.food.online.FoodDelivery.model.FoodMenuItems;

@Validated
public interface FoodService {

    @NotNull Iterable<FoodMenuItems> getAllFoodMenuItems();

    FoodMenuItems getFoodMenuItems(@Min(value = 1L, message = "Invalid product ID.") long id);

    FoodMenuItems save(FoodMenuItems product);
}
