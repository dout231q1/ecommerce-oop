package com.example.shop.database.entity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Product> products;
    private Double total;
    private String paymentType;
    private LocalDate paymentDate;

    public Order(){}

    public Order(User user, List<Product> products, Double total, String paymentType) {
        this.user = user;
        this.products = products;
        this.total = total;
        this.paymentType = paymentType;
        this.paymentDate = LocalDate.now();
    }
}