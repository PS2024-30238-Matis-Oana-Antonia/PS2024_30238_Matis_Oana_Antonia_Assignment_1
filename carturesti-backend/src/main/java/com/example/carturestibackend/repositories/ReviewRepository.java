package com.example.carturestibackend.repositories;

import com.example.carturestibackend.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,String> {
}
