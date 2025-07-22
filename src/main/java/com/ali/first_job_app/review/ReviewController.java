package com.ali.first_job_app.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable("companyId") Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@RequestBody Review review, @PathVariable Long companyId) {
        boolean isReviewSaved = reviewService.createReview(review, companyId);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review Created Successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Review Creation Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable("reviewId") Long reviewId, @PathVariable Long companyId) {
        final Review review = reviewService.getReviewById(reviewId, companyId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewUpdated = reviewService.updateReview(reviewId, companyId, review);
        if (isReviewUpdated) {
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        }else  {
            return new ResponseEntity<>("Review Update Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable("reviewId") Long reviewId, @PathVariable Long companyId) {
        boolean isReviewDeleted = reviewService.deleteReviewById(reviewId, companyId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        }else  {
            return new ResponseEntity<>("Review Deletion Failed", HttpStatus.BAD_REQUEST);
        }
    }

}
