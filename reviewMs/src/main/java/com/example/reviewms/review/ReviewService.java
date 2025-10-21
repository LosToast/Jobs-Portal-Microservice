package com.example.reviewms.review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review findById(Long reviewId);

    boolean updateReview(Long reviewId, Review review);

    boolean deleteReview(Long reviewId);
}
