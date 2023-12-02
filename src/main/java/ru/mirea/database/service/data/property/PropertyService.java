package ru.mirea.database.service.data.property;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;

import java.util.List;

public interface PropertyService {
    Page<Property> findAll(Pageable pageable);
    void saveProperty(PropertyDTO propertyDTO);

    List<City> getAllCities();

    List<TypeOfFood> getAllTypesOfFood();

    List<Owner> getAllOwners();

    List<PropertyType> getAllPropertyTypes();

}
