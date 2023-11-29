package ru.mirea.database.service.data.booking.impl;

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
    public BookingStatus save(BookingStatus bookingStatus) {
        return bookingStatusRepository.save(bookingStatus);
    }

    @Override
    public List<BookingStatus> allStatuses() {
        return bookingStatusRepository.findAll();
    }

    @Override
    public Optional<BookingStatus> getStatusById(Long id) throws NoSuchElementException {
        Optional<BookingStatus> status = bookingStatusRepository.findById(id);
        if (status.isPresent()) {
            return status;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteStatusById(Long id) {
        bookingStatusRepository.deleteById(id);
    }
}
