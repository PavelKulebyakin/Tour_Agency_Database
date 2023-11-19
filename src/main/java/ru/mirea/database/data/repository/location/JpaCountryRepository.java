package ru.mirea.database.data.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.location.Country;

public interface JpaCountryRepository
        extends JpaRepository<Country, Long> {
}
