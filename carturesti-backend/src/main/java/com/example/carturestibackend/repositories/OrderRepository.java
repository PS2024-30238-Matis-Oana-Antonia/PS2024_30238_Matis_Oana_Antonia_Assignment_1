package com.example.carturestibackend.repositories;

import com.example.carturestibackend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
