package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.City;

public interface CityRepository
        extends JpaRepository<City, Long> {
}
