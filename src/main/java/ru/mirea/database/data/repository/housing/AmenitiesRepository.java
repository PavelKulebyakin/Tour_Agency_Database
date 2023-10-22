package ru.mirea.database.data.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.housing.Amenities;

public interface AmenitiesRepository
        extends JpaRepository<Amenities, Long> {
}
