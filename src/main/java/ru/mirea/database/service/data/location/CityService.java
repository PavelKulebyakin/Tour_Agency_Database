package ru.mirea.database.service.data.location;

import ru.mirea.database.data.entity.location.City;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface CityService {
    City save(City city);

    List<City> allCities();

    Optional<City> getCityById(Long id) throws NoSuchElementException;

    void deleteCityById(Long id);
}
