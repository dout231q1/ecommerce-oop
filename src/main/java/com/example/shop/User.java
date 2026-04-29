package com.example.shop;

import jakarta.persistence.*;

@Entity
@Table(name="users") // rename table name user to users
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Double balance;

    public User(){}

    public User(String username, Double balance){
        this.username = username;
        this.balance = balance;
    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public Double getBalance(){
        return balance;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }
}
