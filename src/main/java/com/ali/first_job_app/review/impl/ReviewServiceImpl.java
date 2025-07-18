package com.ali.first_job_app.review.impl;

import com.ali.first_job_app.company.Company;
import com.ali.first_job_app.company.CompanyService;
import com.ali.first_job_app.review.Review;
import com.ali.first_job_app.review.ReviewRepository;
import com.ali.first_job_app.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review getReviewById(Long id) {
        return null;
    }

    @Override
    public boolean createReview(Review review, Long companyId) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean updateReview(Long id, Review review) {
        return false;
    }

    @Override
    public boolean deleteReviewById(Long id) {
        return false;
    }
}
