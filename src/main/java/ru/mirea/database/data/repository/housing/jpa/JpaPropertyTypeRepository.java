package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.dto.NameIdDTO;
import ru.mirea.database.data.entity.property.PropertyType;

import java.util.List;

public interface JpaPropertyTypeRepository
        extends JpaRepository<PropertyType, Long> {
    List<NameIdDTO> findAllBy();
}
