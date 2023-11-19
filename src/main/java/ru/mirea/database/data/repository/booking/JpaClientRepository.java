package ru.mirea.database.data.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.booking.Client;

public interface JpaClientRepository
        extends JpaRepository<Client, Long> {
}
