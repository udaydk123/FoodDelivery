package com.food.online.FoodDelivery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.food.online.FoodDelivery.dto.OrderFoodDto;
import com.food.online.FoodDelivery.exception.ResourceNotFoundException;
import com.food.online.FoodDelivery.model.Order;
import com.food.online.FoodDelivery.model.OrderFood;
import com.food.online.FoodDelivery.model.OrderStatus;
import com.food.online.FoodDelivery.service.FoodService;
import com.food.online.FoodDelivery.service.OrderFoodService;
import com.food.online.FoodDelivery.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    FoodService foodService;
    OrderService orderService;
    OrderFoodService orderProductService;

    public OrderController(FoodService foodService, OrderService orderService, OrderFoodService orderFoodService) {
        this.foodService = foodService;
        this.orderService = orderService;
        this.orderProductService = orderFoodService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderFoodDto> formDtos = form.getFoodOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderFood> orderProducts = new ArrayList<>();
        for (OrderFoodDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderFood(order, foodService.getFoodMenuItems(dto
              .getFood()
              .getId()), dto.getQuantity())));
        }

        order.setOrderFoodItems(orderProducts);

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
          .fromCurrentServletMapping()
          .path("/orders/{id}")
          .buildAndExpand(order.getId())
          .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderFoodDto> orderProducts) {
        List<OrderFoodDto> list = orderProducts
          .stream()
          .filter(op -> Objects.isNull(foodService.getFoodMenuItems(op
            .getFood()
            .getId())))
          .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Food item not found");
        }
    }

    public static class OrderForm {

        private List<OrderFoodDto> foodOrders;

        public List<OrderFoodDto> getFoodOrders() {
            return foodOrders;
        }

        public void setProductOrders(List<OrderFoodDto> foodOrders) {
            this.foodOrders = foodOrders;
        }
    }
}