package com.food.online.FoodDelivery.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.online.FoodDelivery.model.Restaurants;
import com.food.online.FoodDelivery.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantServiceImpl  implements RestaurantService{

	 private RestaurantRepository restuarantRepository;

	    public RestaurantServiceImpl(RestaurantRepository restuarantRepository) {
	        this.restuarantRepository = restuarantRepository;
	    }

	    @Override
	    public Iterable<Restaurants> getAllRestaurants() {
	        return this.restuarantRepository.findAll();
	    }

	    @Override
	    public Restaurants create(Restaurants restaurants) {
	        return this.restuarantRepository.save(restaurants);
	    }

	    @Override
	    public void update(Restaurants restaurants) {
	        this.restuarantRepository.save(restaurants);
	    }

		@Override
		public void delete(Restaurants restaurants) {
			this.restuarantRepository.delete(restaurants);
			
		}
		
		 @Override
		    public Restaurants save(Restaurants product) {
		        return restuarantRepository.save(product);
		    }
}
