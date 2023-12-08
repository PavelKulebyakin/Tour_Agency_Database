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
import ru.mirea.database.data.dto.booking.BookingStatusDTO;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.booking.BookingStatus;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.service.data.booking.BookingStatusService;
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/bookingStatus")
public class BookingStatusController {

    private final BookingStatusService bookingStatusService;

    @Autowired
    public BookingStatusController(BookingStatusService bookingStatusService) {
        this.bookingStatusService = bookingStatusService;
    }

    @ModelAttribute("statuses")
    public List<BookingStatus> statuses() {
        return bookingStatusService.allStatuses();
    }

    @GetMapping
    public String statusView(Model model){
        model.addAttribute("statuses", bookingStatusService.allStatuses());
        return "booking/bookingStatus";
    }

    @GetMapping("save")
    public String saveView(Model model) {
        BookingStatusDTO input = new BookingStatusDTO();
        model.addAttribute("input", input);
        return "booking/bookingStatus_update";
    }

    @PostMapping("/save")
    public String saveStatus(Model model, @Valid @ModelAttribute("input") BookingStatusDTO status) {
        if(status.getId() == null) {
            bookingStatusService.save(status);
        } else {
            bookingStatusService.update(status);
        }
        return "redirect:/bookingStatus?save=true";
    }

    @GetMapping("update/{id}")
    public String updateView(Model model, @PathVariable(name = "id") Long id) {
        BookingStatusDTO input = bookingStatusService.getStatusById(id);
        model.addAttribute("input", input);
        return "booking/bookingStatus_update";
    }

    @PostMapping("/delete/{id}")
    public String deleteProperty(Model model, @PathVariable("id") Long id) {
        try{
            bookingStatusService.deleteStatusById(id);
        } catch (DataIntegrityViolationException e){
            return "redirect:/bookingStatus?error=true";
        }
        return "redirect:/bookingStatus?delete=true";
    }
}
