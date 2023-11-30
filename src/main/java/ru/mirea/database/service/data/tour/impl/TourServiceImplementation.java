package ru.mirea.database.service.data.tour.impl;

import ru.mirea.database.data.entity.tour.Tour;
import ru.mirea.database.data.repository.tour.JpaTourRepository;
import ru.mirea.database.service.data.tour.TourService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TourServiceImplementation implements TourService {
    protected JpaTourRepository tourRepository;

    public TourServiceImplementation(JpaTourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public List<Tour> allTours() {
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> getTourById(Long id) throws NoSuchElementException {
        Optional<Tour> tour = tourRepository.findById(id);
        if(tour.isPresent()) {
            return tour;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteTourById(Long id) {
        tourRepository.deleteById(id);
    }
}
