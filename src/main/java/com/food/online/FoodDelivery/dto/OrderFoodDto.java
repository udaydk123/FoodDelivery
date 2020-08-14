package com.food.online.FoodDelivery.dto;

import com.food.online.FoodDelivery.model.FoodMenuItems;

public class OrderFoodDto {


    private FoodMenuItems food;
    private Integer quantity;
	public FoodMenuItems getFood() {
		return food;
	}
	public void setFood(FoodMenuItems food) {
		this.food = food;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
    
	
    
}
