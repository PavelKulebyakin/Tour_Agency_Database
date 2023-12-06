package ru.mirea.database.service.data.property.impl;

import org.springframework.stereotype.Service;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyTypeRepository;
import ru.mirea.database.service.data.property.PropertyTypeService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;

@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {
    protected JpaPropertyTypeRepository repository;

    public PropertyTypeServiceImpl(JpaPropertyTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PropertyType save(PropertyType propertyType) {
        return repository.save(propertyType);
    }

    @Override
    public List<PropertyType> allTypes() {
        return repository.findAll();
    }

    @Override
    public PropertyType getTypeById(Long id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteTypeById(Long id) {
        repository.deleteById(id);
    }

}
