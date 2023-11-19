package ru.mirea.database.service.data.property.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyRepository;
import ru.mirea.database.service.data.property.PropertyService;

@Service
public class ProrertyServiceImpl implements PropertyService {

    protected final JpaPropertyRepository propertyRepository;

    @Autowired
    public ProrertyServiceImpl(JpaPropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Page<PropertyDTO> findAll(Pageable pageable) {
        return propertyRepository.findAllBy(pageable);
    }
}
