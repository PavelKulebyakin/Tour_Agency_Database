package ru.mirea.database.service.data.ticket.impl;

import ru.mirea.database.data.entity.tickets.Airport;
import ru.mirea.database.data.repository.tickets.JpaAirportRepository;
import ru.mirea.database.service.data.ticket.AirportService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AirportServiceImplementation implements AirportService {
    protected JpaAirportRepository airportRepository;

    public AirportServiceImplementation(JpaAirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> allAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> getAirportById(Long id) throws NoSuchElementException {
        Optional<Airport> airport = airportRepository.findById(id);
        if(airport.isPresent()) {
            return airport;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteAirportById(Long id) {
        airportRepository.deleteById(id);
    }
}
