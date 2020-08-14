package com.food.online.FoodDelivery.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.online.FoodDelivery.exception.ResourceNotFoundException;
import com.food.online.FoodDelivery.model.FoodMenuItems;
import com.food.online.FoodDelivery.repository.FoodRepository;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRespository;

    public FoodServiceImpl(FoodRepository foodRespository) {
        this.foodRespository = foodRespository;
    }

    @Override
    public Iterable<FoodMenuItems> getAllFoodMenuItems() {
        return foodRespository.findAll();
    }

    @Override
    public FoodMenuItems getFoodMenuItems(long id) {
        return foodRespository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Food not found"));
    }

    @Override
    public FoodMenuItems save(FoodMenuItems product) {
        return foodRespository.save(product);
    }
}