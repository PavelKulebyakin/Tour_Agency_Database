package ru.mirea.database.service.data.ticket;

import ru.mirea.database.data.entity.tickets.Airport;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface AirportService {
    Airport save(Airport airport);

    List<Airport> allAirports();

    Optional<Airport> getAirportById(Long id) throws NoSuchElementException;

    void deleteAirportById(Long id);

}
