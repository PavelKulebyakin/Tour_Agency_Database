package ru.mirea.database.service.data.tour;

import ru.mirea.database.data.entity.tour.Tour;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface TourService {
    Tour save(Tour tour);

    List<Tour> allTours();

    Optional<Tour> getTourById(Long id) throws NoSuchElementException;

    void deleteTourById(Long id);
}
