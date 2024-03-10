package com.example.carturestibackend.services;

import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.dtos.builders.ReviewBuilder;
import com.example.carturestibackend.entities.Review;
import com.example.carturestibackend.repositories.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewDTO> findReviews() {
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList.stream()
                .map(ReviewBuilder::toReviewDTO)
                .collect(Collectors.toList());
    }

    public ReviewDTO findReviewById(long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (!reviewOptional.isPresent()) {
            LOGGER.error("Review with id {} was not found in db", id);
            throw new ResourceNotFoundException(Review.class.getSimpleName() + " with id: " + id);
        }
        return ReviewBuilder.toReviewDTO(reviewOptional.get());
    }

    public long insert(ReviewDTO reviewDTO) {
        Review review = ReviewBuilder.fromReviewDTO(reviewDTO);
        review = reviewRepository.save(review);
        LOGGER.debug("Review with id {} was inserted in db", review.getId());
        return review.getId();
    }

    public void deleteReviewById(long id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewRepository.delete(reviewOptional.get());
        } else {
            throw new ResourceNotFoundException(Review.class.getSimpleName() + " with id: " + id);
        }
    }

    public ReviewDTO updateReview(long id, ReviewDTO reviewDTO) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (!reviewOptional.isPresent()) {
            LOGGER.error("Review with id {} was not found in db", id);
            throw new ResourceNotFoundException(Review.class.getSimpleName() + " with id: " + id);
        }

        Review existingReview = reviewOptional.get();
        existingReview.setRating(reviewDTO.getRating());
        existingReview.setComment(reviewDTO.getComment());
        existingReview.setCreatedAt(reviewDTO.getCreatedAt());

        Review updatedReview = reviewRepository.save(existingReview);
        LOGGER.debug("Review with id {} was updated in db", updatedReview.getId());

        return ReviewBuilder.toReviewDTO(updatedReview);
    }
}
