package ru.mirea.database.service.data.location.impl;

import ru.mirea.database.data.entity.location.Country;
import ru.mirea.database.data.repository.location.JpaCountryRepository;
import ru.mirea.database.service.data.location.CountryService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CountryServiceImplementation implements CountryService {
    protected JpaCountryRepository countryRepository;

    public CountryServiceImplementation(JpaCountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> allCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Long id) throws NoSuchElementException {
        Optional<Country> country = countryRepository.findById(id);
        if(country.isPresent()) {
            return country;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }
}
