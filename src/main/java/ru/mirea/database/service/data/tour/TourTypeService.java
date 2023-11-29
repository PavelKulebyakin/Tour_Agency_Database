package ru.mirea.database.service.data.tour;

import ru.mirea.database.data.entity.tour.TourType;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface TourTypeService {
    TourType save(TourType tourType);

    List<TourType> allTypes();

    Optional<TourType> getTypeById(Long id) throws NoSuchElementException;

    void deleteTypeById(Long id);
}
