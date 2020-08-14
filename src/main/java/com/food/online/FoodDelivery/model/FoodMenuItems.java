package com.food.online.FoodDelivery.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class FoodMenuItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Resturant name is required.")
	@Basic(optional = false)
	private String name;

	private String type;
	
	private String itemNames;
	
	private Double price;
	
	private Double peekprice;

	public FoodMenuItems(Long id, @NotNull(message = "Resturant name is required.") String name, String type,
			String itemNames, Double price, Double peekprice) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.itemNames = itemNames;
		this.price = price;
		this.peekprice = peekprice;
	}

	public FoodMenuItems() {
		super();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItemNames() {
		return itemNames;
	}

	public void setItemNames(String itemNames) {
		this.itemNames = itemNames;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPeekprice() {
		return peekprice;
	}

	public void setPeekprice(Double peekprice) {
		this.peekprice = peekprice;
	}
	
	
}
