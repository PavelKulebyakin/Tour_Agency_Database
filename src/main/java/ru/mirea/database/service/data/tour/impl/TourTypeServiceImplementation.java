package ru.mirea.database.service.data.tour.impl;

import ru.mirea.database.data.entity.tour.TourType;
import ru.mirea.database.data.repository.tour.JpaTourTypeRepository;
import ru.mirea.database.service.data.tour.TourTypeService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TourTypeServiceImplementation implements TourTypeService {
    protected JpaTourTypeRepository tourTypeRepository;

    public TourTypeServiceImplementation(JpaTourTypeRepository tourTypeRepository) {
        this.tourTypeRepository = tourTypeRepository;
    }

    @Override
    public TourType save(TourType tourType) {
        return tourTypeRepository.save(tourType);
    }

    @Override
    public List<TourType> allTypes() {
        return tourTypeRepository.findAll();
    }

    @Override
    public Optional<TourType> getTypeById(Long id) throws NoSuchElementException {
        Optional<TourType> tourType = tourTypeRepository.findById(id);
        if(tourType.isPresent()) {
            return tourType;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteTypeById(Long id) {
        tourTypeRepository.deleteById(id);
    }
}
