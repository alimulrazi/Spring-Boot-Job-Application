package com.ali.first_job_app.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    Review getReviewById(Long companyId, Long reviewId);
    boolean createReview(Review review, Long companyId);
    boolean updateReview(Long reviewId, Long companyId,  Review review);
    boolean deleteReviewById(Long reviewId, Long companyId);
}
