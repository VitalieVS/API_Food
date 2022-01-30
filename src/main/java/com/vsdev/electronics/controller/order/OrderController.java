package com.vsdev.electronics.controller.order;

import com.vsdev.electronics.dto.OrderResponse;
import com.vsdev.electronics.entity.order.Order;
import com.vsdev.electronics.service.order.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Inject
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public OrderResponse createOrder(@RequestBody Order order) {

        return this.orderService.createOrder(order);
    }
}
