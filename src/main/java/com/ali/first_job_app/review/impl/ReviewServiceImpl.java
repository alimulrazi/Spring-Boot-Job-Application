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
    public Review getReviewById(Long companyId, Long reviewId) {
        List <Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
            .filter(review -> reviewId.equals(review.getId()))
            .findFirst()
            .orElse(null);
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
    public boolean updateReview(Long reviewId, Long companyId, Review updateReview) {
        if(companyService.getCompanyById(companyId) != null) {
            updateReview.setCompany(companyService.getCompanyById(companyId));
            updateReview.setId(reviewId);
            reviewRepository.save(updateReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId, Long companyId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.findById(reviewId).get();
            Company company = review.getCompany();
            company.getReviews().remove(review);
//            review.setCompany(null);
            companyService.updateCompany(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        else {
            return  false;
        }
    }
}
