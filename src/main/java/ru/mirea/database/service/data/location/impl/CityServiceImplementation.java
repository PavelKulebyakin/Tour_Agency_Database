package ru.mirea.database.service.data.location.impl;

import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.repository.location.JpaCityRepository;
import ru.mirea.database.service.data.location.CityService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CityServiceImplementation implements CityService {
    protected JpaCityRepository cityRepository;

    public CityServiceImplementation(JpaCityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> allCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getCityById(Long id) throws NoSuchElementException {
        Optional<City> city = cityRepository.findById(id);
        if(city.isPresent()) {
            return city;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteCityById(Long id) {
        cityRepository.deleteById(id);
    }
}
