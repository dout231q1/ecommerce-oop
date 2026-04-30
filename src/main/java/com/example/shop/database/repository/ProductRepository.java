package com.example.shop.database.repository;

import com.example.shop.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends  JpaRepository<Product, Long>{
}
