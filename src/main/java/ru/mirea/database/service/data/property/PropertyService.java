package ru.mirea.database.service.data.property;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.property.PropertyInputDTO;
import ru.mirea.database.data.dto.property.PropertyOutputDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Property;

import java.util.List;
import java.util.SortedMap;

public interface PropertyService {

    Property findById(Long id);

    Page<PropertyOutputDTO> findAll(Pageable pageable);

    void save(PropertyInputDTO propertyInputDTO);

    void deleteById(Long id);

    List<City> getAllCities();

    SortedMap<String, Long> getCityNames();

    SortedMap<String, Long> getFoodTypeNames();

    SortedMap<String, Long> getOwnerNames();

    SortedMap<String, Long> getPropertyTypeNames();

}
