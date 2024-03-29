package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.entities.Review;
import com.example.carturestibackend.entities.User;

import static com.example.carturestibackend.dtos.mappers.UserMapper.toUserDTO;
import static com.example.carturestibackend.dtos.mappers.UserMapper.fromUserDTO;

public class ReviewMapper {

    private ReviewMapper() {
    }

    public static ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .user(review.getUser())
                .product(review.getProduct())
                .build();
    }

    public static Review fromReviewDTO(ReviewDTO reviewDTO) {
        return Review.builder()
                .rating(reviewDTO.getRating())
                .comment(reviewDTO.getComment())
                .user(reviewDTO.getUser())
                .product(reviewDTO.getProduct())
                .build();
    }
}
