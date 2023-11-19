package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.property.Property;

public interface JpaPropertyRepository
        extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {

    Page<PropertyDTO> findAllBy (Pageable pageable);
}
