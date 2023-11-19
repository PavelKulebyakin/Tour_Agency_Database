package ru.mirea.database.data.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.location.City;

public interface JpaCityRepository
        extends JpaRepository<City, Long> {
}
