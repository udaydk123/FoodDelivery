package com.food.online.FoodDelivery.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Restaurants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Resturant name is required.")
	@Basic(optional = false)
	private String name;

	@NotNull(message = "Location name is required.")
	@Basic(optional = false)
	private String location;

	private int rating;

	private String pictureUrl;

	private boolean vegetarian;
	private boolean nonVegetarian;

	public Restaurants(Long id, @NotNull(message = "Resturant name is required.") String name,
			@NotNull(message = "Location name is required.") String location, int rating, String pictureUrl,
			boolean vegetarian, boolean nonVegetarian) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.pictureUrl = pictureUrl;
		this.vegetarian = vegetarian;
		this.nonVegetarian = nonVegetarian;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public boolean isNonVegetarian() {
		return nonVegetarian;
	}

	public void setNonVegetarian(boolean nonVegetarian) {
		this.nonVegetarian = nonVegetarian;
	}

	public Restaurants() {
		super();
	}






}
