package ru.mirea.database.service.data.booking;

import ru.mirea.database.data.dto.booking.BookingStatusDTO;
import ru.mirea.database.data.entity.booking.BookingStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface BookingStatusService {

    BookingStatus save(BookingStatusDTO bookingStatus);

    List<BookingStatus> allStatuses();

    BookingStatusDTO getStatusById(Long id) throws NoSuchElementException;

    void deleteStatusById(Long id);

    void update(BookingStatusDTO bookingStatus);

}
