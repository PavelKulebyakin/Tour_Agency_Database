package ru.mirea.database.service.data.location;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.location.RegionDTO;

public interface RegionService {

    Page<RegionDTO> findAll(Pageable pageable);
}
