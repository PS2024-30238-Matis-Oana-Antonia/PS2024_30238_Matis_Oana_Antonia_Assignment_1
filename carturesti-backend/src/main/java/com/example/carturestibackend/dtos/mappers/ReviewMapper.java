package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.entities.Review;

public class ReviewMapper {

    private ReviewMapper() {
    }

    public static ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .build();
    }

    public static Review fromReviewDTO(ReviewDTO reviewDTO) {
        return Review.builder()
                .rating(reviewDTO.getRating())
                .comment(reviewDTO.getComment())
                .build();
    }
}
