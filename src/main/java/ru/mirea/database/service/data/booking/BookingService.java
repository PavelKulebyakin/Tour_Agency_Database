package ru.mirea.database.service.data.booking;

import ru.mirea.database.data.entity.booking.Booking;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface BookingService {

    Booking save(Booking booking);

    List<Booking> allBookings();

    Optional<Booking> getBookingById(Long id) throws NoSuchElementException;

    void deleteBookingById(Long id);

}
