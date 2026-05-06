package com.example.shop.controller;


import com.example.shop.database.entity.Order;
import com.example.shop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/history/{userId}")
    public List<Order> getHistory(@PathVariable Long userId){
        return orderService.getOrderHistoryById(userId);
    }

    @PostMapping("/checkout/{userId}")
    public Order checkout(@PathVariable Long userId, @RequestParam String payment){
        return orderService.checkout(userId, payment);
    }
}