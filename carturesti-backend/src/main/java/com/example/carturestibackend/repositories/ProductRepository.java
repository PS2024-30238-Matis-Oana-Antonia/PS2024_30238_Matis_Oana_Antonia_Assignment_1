package com.example.carturestibackend.repositories;

import com.example.carturestibackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
