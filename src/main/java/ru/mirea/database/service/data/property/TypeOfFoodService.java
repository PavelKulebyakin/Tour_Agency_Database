package ru.mirea.database.service.data.property;

import ru.mirea.database.data.entity.property.TypeOfFood;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;

public interface TypeOfFoodService {
    TypeOfFood save(TypeOfFood typeOfFood);

    List<TypeOfFood> allTypes();

    TypeOfFood getTypeById(Long id) throws NoSuchElementException;

    void deleteTypeById(Long id);

    SortedMap<String, Long> getNamesMap();
}
