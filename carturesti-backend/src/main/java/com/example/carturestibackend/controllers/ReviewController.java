package com.example.carturestibackend.controllers;

import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.services.ProductService;
import com.example.carturestibackend.services.ReviewService;
import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Controller class to handle HTTP requests related to reviews.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;
    private final ProductService productService;

    /**
     * Constructs a new ReviewController with the specified ReviewService.
     *
     * @param reviewService  The ReviewService used to handle review-related business logic.
     * @param userService
     * @param productService
     */
    @Autowired
    public ReviewController(ReviewService reviewService, UserService userService, ProductService productService) {
        this.reviewService = reviewService;
        this.userService = userService;
        this.productService = productService;
    }

    /**
     * Retrieves all reviews.
     *
     * @return A ResponseEntity containing a list of ReviewDTO objects representing the reviews.
     */
    @GetMapping()
    public ResponseEntity<List<ReviewDTO>> getReviews() {
        List<ReviewDTO> dtos = reviewService.findReviews();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Inserts a new review.
     *
     * @param reviewDTO The ReviewDTO object representing the review to insert.
     * @return A ResponseEntity containing the ID of the newly inserted review.
     */
    @PostMapping()
    public ResponseEntity<Long> insert(@Valid @RequestBody ReviewDTO reviewDTO) {
        long reviewID = reviewService.insert(reviewDTO);
        return new ResponseEntity<>(reviewID, HttpStatus.CREATED);
    }

    /**
     * Retrieves a review by its ID.
     *
     * @param reviewID The ID of the review to retrieve.
     * @return A ResponseEntity containing the ReviewDTO object representing the retrieved review.
     */
    @GetMapping(value = "/{id_review}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable("id_review") long reviewID) {
        ReviewDTO dto = reviewService.findReviewById(reviewID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Deletes a review by its ID.
     *
     * @param reviewID The ID of the review to delete.
     * @return A ResponseEntity indicating the success of the operation.
     */
    @DeleteMapping(value = "/{id_review}")
    public ResponseEntity<String> deleteReview(@PathVariable("id_review") long reviewID) {
        reviewService.deleteReviewById(reviewID);
        return new ResponseEntity<>("Review with ID " + reviewID + " deleted successfully", HttpStatus.OK);
    }

    /**
     * Updates a review by its ID.
     *
     * @param reviewID   The ID of the review to update.
     * @param reviewDTO  The updated ReviewDTO object representing the new state of the review.
     * @return A ResponseEntity containing the updated ReviewDTO object.
     */
    @PutMapping(value = "/{id_review}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable("id_review") long reviewID, @Valid @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO updatedReview = reviewService.updateReview(reviewID, reviewDTO);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }
}
