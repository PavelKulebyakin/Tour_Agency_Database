package ru.mirea.database.service.data.booking.impl;

import ru.mirea.database.data.dto.booking.BookingDTO;
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
    public Booking save(BookingDTO booking) {
        return null;
    }

    @Override
    public List<Booking> allBookings() {
        return null;
    }

    @Override
    public BookingDTO getBookingById(Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public void deleteBookingById(Long id) {

    }

    @Override
    public void update(BookingDTO bookingDTO) {

    }
}
