package ru.mirea.database.service.data.booking;

import ru.mirea.database.data.entity.booking.Review;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ReviewService {

    Review save(Review review);

    List<Review> allReviews();

    Optional<Review> getReviewById(Long id) throws NoSuchElementException;

    void deleteReviewById(Long id);

}
