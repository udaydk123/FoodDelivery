package com.food.online.FoodDelivery.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderFood {

    @EmbeddedId
    @JsonIgnore
    private OrderFoodPK pk;

    @Column(nullable = false) private Integer quantity;

    public OrderFood() {
        super();
    }

    public OrderFood(Order order, FoodMenuItems foodMenuItems, Integer quantity) {
        pk = new OrderFoodPK();
        pk.setOrder(order);
        pk.setFoodMenuItems(foodMenuItems);
        this.quantity = quantity;
    }

    @Transient
    public FoodMenuItems getFoodItems() {
        return this.pk.getFoodMenuItems();
    }

    @Transient
    public Double getTotalPrice() {
        return getFoodItems().getPrice() * getQuantity();
    }

    public OrderFoodPK getPk() {
        return pk;
    }

    public void setPk(OrderFoodPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderFood other = (OrderFood) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }
}