package ru.mirea.database.service.data.booking;

import ru.mirea.database.data.dto.booking.ReviewDTO;
import ru.mirea.database.data.entity.booking.Review;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ReviewService {

    Review save(ReviewDTO review);

    List<Review> allReviews();

    ReviewDTO getReviewById(Long id) throws NoSuchElementException;

    void deleteReviewById(Long id);

    void update(ReviewDTO review);

}
