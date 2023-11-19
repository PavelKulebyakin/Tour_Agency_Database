package ru.mirea.database.data.repository.tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.tickets.Airline;

public interface JpaAirlineRepository
    extends JpaRepository<Airline, Long> {
}
