package ru.mirea.database.service.data.booking.impl;

import ru.mirea.database.data.dto.booking.BookingStatusDTO;
import ru.mirea.database.data.entity.booking.BookingStatus;
import ru.mirea.database.data.repository.booking.JpaBookingStatusRepository;
import ru.mirea.database.service.data.booking.BookingStatusService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookingStatusServiceImplementation implements BookingStatusService {

    protected JpaBookingStatusRepository bookingStatusRepository;

    public BookingStatusServiceImplementation(JpaBookingStatusRepository bookingStatusRepository) {
        this.bookingStatusRepository = bookingStatusRepository;
    }

    @Override
    public BookingStatus save(BookingStatusDTO bookingStatus) {
        return null;
    }

    @Override
    public List<BookingStatus> allStatuses() {
        return bookingStatusRepository.findAll();
    }

    @Override
    public BookingStatusDTO getStatusById(Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public void deleteStatusById(Long id) {
        bookingStatusRepository.deleteById(id);
    }

    @Override
    public void update(BookingStatusDTO bookingStatus) {

    }
}
