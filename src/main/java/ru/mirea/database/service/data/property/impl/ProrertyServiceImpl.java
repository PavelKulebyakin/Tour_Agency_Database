package ru.mirea.database.service.data.property.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.property.PropertyInputDTO;
import ru.mirea.database.data.dto.property.PropertyOutputDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyRepository;
import ru.mirea.database.service.data.location.CityService;
import ru.mirea.database.service.data.owner.OwnerService;
import ru.mirea.database.service.data.property.PropertyService;
import ru.mirea.database.service.data.property.PropertyTypeService;
import ru.mirea.database.service.data.property.TypeOfFoodService;
import ru.mirea.database.service.data.tour.TourService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.SortedMap;

// TODO: 01.12.2023 devide into two services

@Service
public class ProrertyServiceImpl implements PropertyService {

    protected final JpaPropertyRepository propertyRepository;
    protected final CityService cityService;
    protected final TypeOfFoodService typeOfFoodService;
    protected final OwnerService ownerService;
    protected final PropertyTypeService propertyTypeService;
    protected final TourService tourService;

    @Autowired
    public ProrertyServiceImpl(JpaPropertyRepository property, CityService cityService, TypeOfFoodService typeOfFoodService,
                               OwnerService ownerService, PropertyTypeService propertyTypeService, TourService tourService, ModelMapper modelMapper) {
        this.propertyRepository = property;
        this.cityService = cityService;
        this.typeOfFoodService = typeOfFoodService;
        this.ownerService = ownerService;
        this.propertyTypeService = propertyTypeService;
        this.tourService = tourService;
    }

    @Override
    public Property findById(Long id) {
        Optional<Property> optional = propertyRepository.findById(id);
        return optional.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Page<PropertyOutputDTO> findAll(Pageable pageable) {
        return propertyRepository.findAllAsDTO(pageable);
    }

    @Override
    public void save(PropertyInputDTO input) {
        City city = cityService.getCityById(input.getCityId());
        TypeOfFood typeOfFood = typeOfFoodService.getTypeById(input.getTypeOfFoodId());
        Owner owner = ownerService.getOwnerById(input.getOwnerId());
        PropertyType propertyType = propertyTypeService.getTypeById(input.getPropertyTypeId());
        Property property = new Property(input.getName(), input.getAddress(), input.getNumberOfRooms(),
                input.getCapacity(), typeOfFood, city, owner, propertyType);
        propertyRepository.save(property);
//        propertyRepository.save(input);
    }

    @Override                                                                   // TODO: 30.11.2023 add transaction
    public void deleteById(Long id) {
        if(tourService.referencesPropertyById(id)) throw new RuntimeException();
        propertyRepository.deleteById(id);
    }

    @Override
    public List<City> getAllCities() {
        return cityService.allCities();
    }

    @Override
    public SortedMap<String, Long> getCityNames() {
        return cityService.getNamesMap();
    }

    @Override
    public SortedMap<String, Long> getFoodTypeNames() {
        return typeOfFoodService.getNamesMap();
    }

    @Override
    public SortedMap<String, Long> getOwnerNames() {
        return ownerService.getNamesMap();
    }

    @Override
    public SortedMap<String, Long> getPropertyTypeNames() {
        return propertyTypeService.getNamesMap();
    }
}
