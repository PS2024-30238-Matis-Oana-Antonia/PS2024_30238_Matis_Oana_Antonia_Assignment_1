package com.example.carturestibackend.controllers;

import com.example.carturestibackend.services.ReviewService;
import com.example.carturestibackend.dtos.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public ResponseEntity<List<ReviewDTO>> getReviews() {
        List<ReviewDTO> dtos = reviewService.findReviews();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insert(@Valid @RequestBody ReviewDTO reviewDTO) {
        long reviewID = reviewService.insert(reviewDTO);
        return new ResponseEntity<>(reviewID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id_review}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable("id_review") long reviewID) {
        ReviewDTO dto = reviewService.findReviewById(reviewID);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_review}")
    public ResponseEntity<String> deleteReview(@PathVariable("id_review") long reviewID) {
        reviewService.deleteReviewById(reviewID);
        return new ResponseEntity<>("Review with ID " + reviewID + " deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/{id_review}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable("id_review") long reviewID, @Valid @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO updatedReview = reviewService.updateReview(reviewID, reviewDTO);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }
}
