package ru.mirea.database.service.data.location.impl;

import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.NameIdDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.repository.location.JpaCityRepository;
import ru.mirea.database.service.data.location.CityService;

import java.util.*;

@Service
public class CityServiceImpl implements CityService {
    protected JpaCityRepository cityRepository;

    public CityServiceImpl(JpaCityRepository cityRepository) {
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
    public City getCityById(Long id) throws NoSuchElementException {
        return cityRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteCityById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public SortedMap<String, Long> getNamesMap() {
        return NameIdDTO.toSortedMap(cityRepository.findAllBy());
    }
}
