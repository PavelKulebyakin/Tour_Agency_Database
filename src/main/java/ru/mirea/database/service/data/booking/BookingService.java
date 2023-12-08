package ru.mirea.database.service.data.booking;

import ru.mirea.database.data.dto.booking.BookingDTO;
import ru.mirea.database.data.entity.booking.Booking;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface BookingService {

    Booking save(BookingDTO booking);

    List<Booking> allBookings();

    BookingDTO getBookingById(Long id) throws NoSuchElementException;

    void deleteBookingById(Long id);

    void update(BookingDTO bookingDTO);

}
