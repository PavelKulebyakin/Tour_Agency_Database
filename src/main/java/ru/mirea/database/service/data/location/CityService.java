package ru.mirea.database.service.data.location;

import ru.mirea.database.data.entity.location.City;

import java.util.*;

public interface CityService {
    City save(City city);

    List<City> allCities();

    City getCityById(Long id) throws NoSuchElementException;

    void deleteCityById(Long id);

    SortedMap<String, Long> getNamesMap();
}
