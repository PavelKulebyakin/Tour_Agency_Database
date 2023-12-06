package ru.mirea.database.service.data.property;

import ru.mirea.database.data.entity.property.PropertyType;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;

public interface PropertyTypeService {
    PropertyType save(PropertyType propertyType);

    List<PropertyType> allTypes();

    PropertyType getTypeById(Long id) throws NoSuchElementException;

    void deleteTypeById(Long id);

}
