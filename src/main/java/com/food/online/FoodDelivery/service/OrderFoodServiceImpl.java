package com.food.online.FoodDelivery.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.food.online.FoodDelivery.model.OrderFood;
import com.food.online.FoodDelivery.repository.OrderFoodRepository;


@Service
@Transactional
public class OrderFoodServiceImpl implements OrderFoodService {

    private OrderFoodRepository orderProductRepository;

    public OrderFoodServiceImpl(OrderFoodRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderFood create(OrderFood orderfood) {
        return this.orderProductRepository.save(orderfood);
    }
}