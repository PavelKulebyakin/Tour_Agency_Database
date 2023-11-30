package ru.mirea.database.service.data.property.impl;

import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.data.repository.housing.jpa.JpaTypeOfFoodRepository;
import ru.mirea.database.service.data.property.TypeOfFoodService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TypeOfFoodServiceImplementation implements TypeOfFoodService {
    protected JpaTypeOfFoodRepository typeOfFoodRepository;

    public TypeOfFoodServiceImplementation(JpaTypeOfFoodRepository typeOfFoodRepository) {
        this.typeOfFoodRepository = typeOfFoodRepository;
    }

    @Override
    public TypeOfFood save(TypeOfFood typeOfFood) {
        return typeOfFoodRepository.save(typeOfFood);
    }

    @Override
    public List<TypeOfFood> allTypes() {
        return typeOfFoodRepository.findAll();
    }

    @Override
    public Optional<TypeOfFood> getTypeById(Long id) throws NoSuchElementException {
        Optional<TypeOfFood> typeOfFood = typeOfFoodRepository.findById(id);
        if(typeOfFood.isPresent()) {
            return typeOfFood;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteTypeById(Long id) {
        typeOfFoodRepository.deleteById(id);
    }
}
