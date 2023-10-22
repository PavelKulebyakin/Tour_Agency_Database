package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.Region;

public interface RegionRepository
        extends JpaRepository<Region, Long> {
}
