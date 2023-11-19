package ru.mirea.database.service.data.property;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.property.PropertyDTO;

public interface PropertyService {
    Page<PropertyDTO> findAll(Pageable pageable);
}
