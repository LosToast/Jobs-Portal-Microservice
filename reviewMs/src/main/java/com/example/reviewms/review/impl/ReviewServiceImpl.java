package com.example.reviewms.review.impl;


import com.example.reviewms.review.Review;
import com.example.reviewms.review.ReviewRepository;
import com.example.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if (companyId != null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review findById( Long reviewId) {
        /*List<Review> reviews = findAll(companyId);
        for (Review review : reviews){
            if (Objects.equals(review.getId(), reviewId)) return review;
        }
        return null;*/
        List<Review> reviews = reviewRepository.findByCompanyId(reviewId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review newReview) {
        List<Review> reviews = reviewRepository.findByCompanyId(reviewId);

        for (Review review : reviews) {
            if (review.getId().equals(reviewId)){
                review.setName(newReview.getName());
                review.setDescription(newReview.getDescription());
                review.setRating(newReview.getRating());
                //review.setCompany(newReview);
                reviewRepository.save(review);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReview( Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(reviewId);

        for (Review review : reviews){
            if (review.getId().equals(reviewId)) {
                reviewRepository.delete(review);
                return true;
            }
        }
        return false;
    }

}
