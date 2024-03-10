package com.example.carturestibackend.dtos.builders;

import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.entities.Review;
import com.example.carturestibackend.entities.User;

public class ReviewBuilder {

    private ReviewBuilder() {
    }

    public static ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .user(UserBuilder.toUserDTO(review.getUser()))
                .product(ProductBuilder.toProductDTO(review.getProduct()))
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review fromReviewDTO(ReviewDTO reviewDTO) {
        return Review.builder()
                .user(UserBuilder.fromUserDTO(reviewDTO.getUser()))
                .product(ProductBuilder.fromProductDTO(reviewDTO.getProduct()))
                .rating(reviewDTO.getRating())
                .comment(reviewDTO.getComment())
                .createdAt(reviewDTO.getCreatedAt())
                .build();
    }
}
