package com.example.carturestibackend.services;

import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.dtos.mappers.ReviewMapper;
import com.example.carturestibackend.entities.Review;
import com.example.carturestibackend.repositories.ReviewRepository;
import com.example.carturestibackend.repositories.ProductRepository;
import com.example.carturestibackend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class to handle business logic related to reviews.
 */
@Service
public class ReviewService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    /**
     * Constructs a new ReviewService with the specified ReviewRepository.
     *
     * @param reviewRepository  The ReviewRepository used to interact with review data in the database.
     * @param userRepository
     * @param productRepository
     */
    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    /**
     * Retrieves all reviews from the database.
     *
     * @return A list of ReviewDTO objects representing the reviews.
     */
    public List<ReviewDTO> findReviews() {
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList.stream()
                .map(ReviewMapper::toReviewDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a review by its ID.
     *
     * @param id The ID of the review to retrieve.
     * @return The ReviewDTO object representing the retrieved review.
     * @throws ResourceNotFoundException if the review with the specified ID is not found.
     */
    public ReviewDTO findReviewById(String id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (!reviewOptional.isPresent()) {
            LOGGER.error("Review with id {} was not found in db", id);
            throw new ResourceNotFoundException(Review.class.getSimpleName() + " with id: " + id);
        }
        return ReviewMapper.toReviewDTO(reviewOptional.get());
    }

    /**
     * Inserts a new review into the database.
     *
     * @param reviewDTO The ReviewDTO object representing the review to insert.
     * @return The ID of the newly inserted review.
     */
    public String insert(ReviewDTO reviewDTO) {
        Review review = ReviewMapper.fromReviewDTO(reviewDTO);
        review = reviewRepository.save(review);
        LOGGER.debug("Review with id {} was inserted in db", review.getId());
        return review.getId();
    }


    /**
     * Deletes a review from the database by its ID.
     *
     * @param id The ID of the review to delete.
     * @throws ResourceNotFoundException if the review with the specified ID is not found.
     */
    public void deleteReviewById(String id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewRepository.delete(reviewOptional.get());
            LOGGER.debug("Review with id {} was deleted from db", id);
        } else {
            LOGGER.error("Review with id {} was not found in db", id);
            throw new ResourceNotFoundException(Review.class.getSimpleName() + " with id: " + id);
        }
    }


    /**
     * Updates an existing review in the database.
     *
     * @param id        The ID of the review to update.
     * @param reviewDTO The updated ReviewDTO object representing the new state of the review.
     * @return The updated ReviewDTO object.
     * @throws ResourceNotFoundException if the review with the specified ID is not found.
     */
    public ReviewDTO updateReview(String id, ReviewDTO reviewDTO) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (!reviewOptional.isPresent()) {
            LOGGER.error("Review with id {} was not found in db", id);
            throw new ResourceNotFoundException(Review.class.getSimpleName() + " with id: " + id);
        }

        Review existingReview = reviewOptional.get();
        existingReview.setRating(reviewDTO.getRating());
        existingReview.setComment(reviewDTO.getComment());

        Review updatedReview = reviewRepository.save(existingReview);
        LOGGER.debug("Review with id {} was updated in db", updatedReview.getId());

        return ReviewMapper.toReviewDTO(updatedReview);
    }
}
