package ru.mirea.database.data.repository.location;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.dto.location.RegionDTO;
import ru.mirea.database.data.entity.location.Region;

public interface JpaRegionRepository
        extends JpaRepository<Region, Long> {
    Page<RegionDTO> findAllBy(Pageable pageable);
}
