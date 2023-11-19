package ru.mirea.database.data.repository.tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.tickets.Ticket;

public interface JpaTicketRepository
    extends JpaRepository<Ticket, Long> {
}
