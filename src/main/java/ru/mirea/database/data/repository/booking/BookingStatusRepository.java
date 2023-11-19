package ru.mirea.database.data.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.booking.BookingStatus;

public interface BookingStatusRepository
    extends JpaRepository<BookingStatus, Long> {
}
