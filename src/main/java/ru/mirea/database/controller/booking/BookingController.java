package ru.mirea.database.controller.booking;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.booking.BookingDTO;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.booking.Booking;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.service.data.booking.BookingService;
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @ModelAttribute("bookings")
    public List<Booking> bookings() {
        return bookingService.allBookings();
    }

    @GetMapping
    public String bookingView(Model model) {
        model.addAttribute("bookings", bookingService.allBookings());
        return "booking/booking";
    }

    @GetMapping("save")
    public String saveView(Model model) {
        BookingDTO input = new BookingDTO();
        model.addAttribute("input", input);
        return "booking/booking_update";
    }

    @PostMapping("/save")
    public String saveBooking(Model model, @Valid @ModelAttribute("input") BookingDTO booking) {
        if (booking.getId() == null) {
                bookingService.save(booking);
        } else {
            bookingService.update(booking);
        }
        return "redirect:/booking?save=true";
    }

    @GetMapping("update/{id}")
    public String updateView(Model model, @PathVariable(name = "id") Long id) {
        BookingDTO input = bookingService.getBookingById(id);
        model.addAttribute("input", input);
        return "booking/booking_update";
    }

    @PostMapping("/delete/{id}")
    public String deleteProperty(Model model, @PathVariable("id") Long id) {
        try {
            bookingService.deleteBookingById(id);
        } catch (DataIntegrityViolationException e) {
            return "redirect:/booking?error=true";
        }
        return "redirect:/booking?delete=true";
    }
}
