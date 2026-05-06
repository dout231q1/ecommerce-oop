package com.example.shop.database.repository;

import com.example.shop.database.entity.Order;
import com.example.shop.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}