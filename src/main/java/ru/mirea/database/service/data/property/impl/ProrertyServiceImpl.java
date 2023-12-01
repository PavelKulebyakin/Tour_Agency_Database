package ru.mirea.database.service.data.property.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;

@Service
public class ProrertyServiceImpl implements PropertyService {

    protected final JpaPropertyRepository propertyRepository;
    protected final JpaCityRepository cityRepository;
    protected final JpaTypeOfFoodRepository typeOfFoodRepository;
    protected final JpaOwnerRepository ownerRepository;
    protected final JpaPropertyTypeRepository propertyTypeRepository;
    protected final ModelMapper modelMapper;

    @Autowired
    public ProrertyServiceImpl(JpaPropertyRepository property, JpaCityRepository city, JpaTypeOfFoodRepository typeOfFood,
                               JpaOwnerRepository owner, JpaPropertyTypeRepository propertyType, ModelMapper modelMapper) {
        this.propertyRepository = property;
        this.cityRepository = city;
        this.typeOfFoodRepository = typeOfFood;
        this.ownerRepository = owner;
        this.propertyTypeRepository = propertyType;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<Property> findAll(Pageable pageable) {
        return propertyRepository.findAllBy(pageable);
    }

    @Override
    public void saveProperty(PropertyDTO propertyDTO) {
        Property property = modelMapper.map(propertyDTO, Property.class);
        propertyRepository.save(property);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<TypeOfFood> getAllTypesOfFood() {
        return typeOfFoodRepository.findAll();
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeRepository.findAll();
    }

}
