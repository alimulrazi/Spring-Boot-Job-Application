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

}
