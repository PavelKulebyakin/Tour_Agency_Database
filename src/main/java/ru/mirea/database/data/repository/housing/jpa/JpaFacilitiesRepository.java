package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.property.Facilities;

public interface JpaFacilitiesRepository
        extends JpaRepository<Facilities, Long> {
}
