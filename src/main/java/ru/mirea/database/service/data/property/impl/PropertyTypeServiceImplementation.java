package ru.mirea.database.service.data.property.impl;

import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyTypeRepository;
import ru.mirea.database.service.data.property.PropertyTypeService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PropertyTypeServiceImplementation implements PropertyTypeService {
    protected JpaPropertyTypeRepository propertyTypeRepository;

    public PropertyTypeServiceImplementation(JpaPropertyTypeRepository propertyTypeRepository) {
        this.propertyTypeRepository = propertyTypeRepository;
    }

    @Override
    public PropertyType save(PropertyType propertyType) {
        return propertyTypeRepository.save(propertyType);
    }

    @Override
    public List<PropertyType> allTypes() {
        return propertyTypeRepository.findAll();
    }

    @Override
    public Optional<PropertyType> getTypeById(Long id) throws NoSuchElementException {
        Optional<PropertyType> propertyType = propertyTypeRepository.findById(id);
        if(propertyType.isPresent()) {
            return propertyType;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteTypeById(Long id) {
        propertyTypeRepository.deleteById(id);
    }
}
