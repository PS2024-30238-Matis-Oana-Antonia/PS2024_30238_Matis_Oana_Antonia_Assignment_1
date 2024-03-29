package com.example.carturestibackend.repositories;

import com.example.carturestibackend.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, String> {
}
