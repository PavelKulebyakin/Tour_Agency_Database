package ru.mirea.database.service.data.property;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;

import java.util.List;

public interface PropertyService {

    Page<PropertyDTO> findAll(Pageable pageable);

    void save(PropertyDTO property);

    void deleteById(Long id);

    List<City> getCities();

    List<TypeOfFood> getTypesOfFood();

    List<Owner> getOwners();

    List<PropertyType> getPropertyTypes();

    void update(PropertyDTO property);

    PropertyDTO findById(Long id);

}
