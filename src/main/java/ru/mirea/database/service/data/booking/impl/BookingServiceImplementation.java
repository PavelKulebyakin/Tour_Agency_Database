package ru.mirea.database.service.data.booking.impl;

import ru.mirea.database.data.entity.booking.Booking;
import ru.mirea.database.service.data.booking.BookingService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookingServiceImplementation implements BookingService {

    /*protected JpaBookingRepository bookingRepository;

    public BookingServiceImplementation(JpaBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }*/

    @Override
    public Booking save(Booking booking) {
        return null;
    }

    @Override
    public List<Booking> allBookings() {
        return null;
    }

    @Override
    public Optional<Booking> getBookingById(Long id) throws NoSuchElementException {
        return Optional.empty();
    }

    @Override
    public void deleteBookingById(Long id) {

    }
}
