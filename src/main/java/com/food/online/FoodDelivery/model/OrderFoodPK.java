package com.food.online.FoodDelivery.model;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
public class OrderFoodPK implements Serializable {

    private static final long serialVersionUID = 476151177562655457L;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "foodMenuItems_id")
    private FoodMenuItems foodMenuItems;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

   
    public FoodMenuItems getFoodMenuItems() {
		return foodMenuItems;
	}

	public void setFoodMenuItems(FoodMenuItems foodMenuItems) {
		this.foodMenuItems = foodMenuItems;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((order.getId() == null)
          ? 0
          : order
            .getId()
            .hashCode());
        result = prime * result + ((foodMenuItems.getId() == null)
          ? 0
          : foodMenuItems
            .getId()
            .hashCode());

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
        OrderFoodPK other = (OrderFoodPK) obj;
        if (order == null) {
            if (other.order != null) {
                return false;
            }
        } else if (!order.equals(other.order)) {
            return false;
        }

        if (foodMenuItems == null) {
            if (other.foodMenuItems != null) {
                return false;
            }
        } else if (!foodMenuItems.equals(other.foodMenuItems)) {
            return false;
        }

        return true;
    }
}