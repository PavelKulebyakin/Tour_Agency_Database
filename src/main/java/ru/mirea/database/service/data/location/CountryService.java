package ru.mirea.database.service.data.location;

import ru.mirea.database.data.entity.location.Country;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface CountryService {
    Country save(Country country);

    List<Country> allCountries();

    Optional<Country> getCountryById(Long id) throws NoSuchElementException;

    void deleteCountryById(Long id);
}
