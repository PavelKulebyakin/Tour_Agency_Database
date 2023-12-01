package ru.mirea.database.service.data.property.impl;

import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.NameIdDTO;
import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.data.repository.housing.jpa.JpaTypeOfFoodRepository;
import ru.mirea.database.service.data.property.TypeOfFoodService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.SortedMap;

@Service
public class TypeOfFoodServiceImpl implements TypeOfFoodService {
    protected JpaTypeOfFoodRepository typeOfFoodRepository;

    public TypeOfFoodServiceImpl(JpaTypeOfFoodRepository typeOfFoodRepository) {
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
    public TypeOfFood getTypeById(Long id) throws NoSuchElementException {
        return typeOfFoodRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteTypeById(Long id) {
        typeOfFoodRepository.deleteById(id);
    }

    @Override
    public SortedMap<String, Long> getNamesMap() {
        return NameIdDTO.toSortedMap(typeOfFoodRepository.findAllBy());
    }
}
