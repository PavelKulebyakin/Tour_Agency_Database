package ru.mirea.database.data.repository.housing.castom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.property.Property;

public interface PropertySearchRepository {

    Page<PropertyDTO> findNameAndAddressBy(Specification<Property> specification, Pageable pageable);
}
