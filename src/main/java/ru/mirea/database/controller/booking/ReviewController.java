package ru.mirea.database.controller.booking;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.booking.ClientDTO;
import ru.mirea.database.data.dto.booking.ReviewDTO;
import ru.mirea.database.data.entity.booking.Client;
import ru.mirea.database.data.entity.booking.Review;
import ru.mirea.database.service.data.booking.ClientService;
import ru.mirea.database.service.data.booking.ReviewService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @ModelAttribute("reviews")
    public List<Review> reviews() {
        return reviewService.allReviews();
    }

    @GetMapping
    public String reviewView(Model model) {
        model.addAttribute("clients", reviewService.allReviews());
        return "booking/review";
    }

    @GetMapping("save")
    public String saveView(Model model) {
        ReviewDTO input = new ReviewDTO();
        model.addAttribute("input", input);
        return "booking/review";
    }

    @PostMapping("/save")
    public String saveReview(Model model, @Valid @ModelAttribute("input") ReviewDTO review) {
        if (review.getId() == null) {
                reviewService.save(review);
        } else {
            reviewService.update(review);
        }
        return "redirect:/review?save=true";
    }

    @GetMapping("update/{id}")
    public String updateView(Model model, @PathVariable(name = "id") Long id) {
        ReviewDTO input = reviewService.getReviewById(id);
        model.addAttribute("input", input);
        return "booking/review";
    }

    @PostMapping("/delete/{id}")
    public String deleteReview(Model model, @PathVariable("id") Long id) {
        try {
            reviewService.deleteReviewById(id);
        } catch (DataIntegrityViolationException e) {
            return "redirect:/review?error=true";
        }
        return "redirect:/review?delete=true";
    }
}
