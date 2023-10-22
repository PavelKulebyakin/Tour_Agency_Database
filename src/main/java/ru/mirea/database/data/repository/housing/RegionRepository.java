package ru.mirea.database.data.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.housing.Region;

public interface RegionRepository
        extends JpaRepository<Region, Long> {
}
