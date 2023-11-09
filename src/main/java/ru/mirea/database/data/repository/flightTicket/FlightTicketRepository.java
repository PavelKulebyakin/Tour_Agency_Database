package ru.mirea.database.data.repository.flightTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.flightTicket.FlightTicket;

public interface FlightTicketRepository
    extends JpaRepository<FlightTicket, Long> {
}
