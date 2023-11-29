package ru.mirea.database.service.data.booking;

import ru.mirea.database.data.entity.booking.BookingStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface BookingStatusService {

    BookingStatus save(BookingStatus bookingStatus);

    List<BookingStatus> allStatuses();

    Optional<BookingStatus> getStatusById(Long id) throws NoSuchElementException;

    void deleteStatusById(Long id);

}
