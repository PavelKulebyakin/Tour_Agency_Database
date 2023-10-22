package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.Country;

public interface CountryRepository
        extends JpaRepository<Country, Long> {
}
