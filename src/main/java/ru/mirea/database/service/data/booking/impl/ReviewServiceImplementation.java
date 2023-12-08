package ru.mirea.database.service.data.booking.impl;

import ru.mirea.database.data.dto.booking.ReviewDTO;
import ru.mirea.database.data.entity.booking.Review;
import ru.mirea.database.service.data.booking.ReviewService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ReviewServiceImplementation implements ReviewService {
    /*protected JpaReviewRepository reviewRepository;

    public ReviewServiceImplementation(JpaReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }*/

    @Override
    public Review save(ReviewDTO review) {
        return null;
    }

    @Override
    public List<Review> allReviews() {
        return null;
    }

    @Override
    public ReviewDTO getReviewById(Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public void deleteReviewById(Long id) {

    }

    @Override
    public void update(ReviewDTO review) {

    }
}
