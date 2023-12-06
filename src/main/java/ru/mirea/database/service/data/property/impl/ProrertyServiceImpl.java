package ru.mirea.database.service.data.property.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.data.repository.housing.jpa.JpaOwnerRepository;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyRepository;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyTypeRepository;
import ru.mirea.database.data.repository.housing.jpa.JpaTypeOfFoodRepository;
import ru.mirea.database.data.repository.location.JpaCityRepository;
import ru.mirea.database.data.repository.tour.JpaTourRepository;
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class ProrertyServiceImpl implements PropertyService {

    protected final JpaPropertyRepository propertyRepository;
    protected final JpaTourRepository tourRepository;
    protected final JpaCityRepository cityRepository;
    protected final JpaTypeOfFoodRepository typeOfFoodRepository;
    protected final JpaOwnerRepository ownerRepository;
    protected final JpaPropertyTypeRepository propertyTypeRepository;
    protected final ModelMapper modelMapper;

    @Autowired
    public ProrertyServiceImpl(JpaPropertyRepository property, JpaTourRepository tourRepository, JpaCityRepository city,
                               JpaTypeOfFoodRepository typeOfFood, JpaOwnerRepository owner, JpaPropertyTypeRepository propertyType,
                               ModelMapper modelMapper) {
        this.propertyRepository = property;
        this.tourRepository = tourRepository;
        this.cityRepository = city;
        this.typeOfFoodRepository = typeOfFood;
        this.ownerRepository = owner;
        this.propertyTypeRepository = propertyType;
        this.modelMapper = modelMapper;
    }

    public PropertyDTO findById(Long id) {
        Property property = propertyRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return modelMapper.map(property, PropertyDTO.class);
    }

    @Override
    public Page<PropertyDTO> findAll(Pageable pageable) {
        Page<Property> page = propertyRepository.findAllBy(pageable);
        return page.map(c -> modelMapper.map(c, PropertyDTO.class));
    }

    @Override
    public void save(PropertyDTO propertyDTO) {
        Property property = modelMapper.map(propertyDTO, Property.class);
        propertyRepository.save(property);
    }

    @Override
    public void deleteById(Long id) {
        if (tourRepository.existsByProperty_Id(id)) throw
                new DataIntegrityViolationException("Cannot delete entity with id %d due to existing references.".formatted(id));
        propertyRepository.deleteById(id);
    }

    private static Sort sortByName() {
        return Sort.by("name");
    }

    @Override
    public List<City> getCities() {
        return cityRepository.findAll(sortByName());
    }

    @Override
    public List<TypeOfFood> getTypesOfFood() {
        return typeOfFoodRepository.findAll(sortByName());
    }

    @Override
    public List<Owner> getOwners() {
        return ownerRepository.findAll(sortByName());
    }

    @Override
    public List<PropertyType> getPropertyTypes() {
        return propertyTypeRepository.findAll(sortByName());
    }

    @Override
    public void update(PropertyDTO propertyDTO) {
        Property property = modelMapper.map(propertyDTO, Property.class);
        propertyRepository.save(property);
    }

}
