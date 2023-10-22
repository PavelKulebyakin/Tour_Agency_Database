package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.Amenities;

public interface AmenitiesRepository
        extends JpaRepository<Amenities, Long> {
}
