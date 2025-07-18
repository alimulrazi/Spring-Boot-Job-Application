package com.ali.first_job_app.review;

import com.ali.first_job_app.company.Company;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    Review getReviewById(Long id);
    boolean createReview(Review review, Long companyId);
    boolean updateReview(Long id, Review review);
    boolean deleteReviewById(Long id);
}
