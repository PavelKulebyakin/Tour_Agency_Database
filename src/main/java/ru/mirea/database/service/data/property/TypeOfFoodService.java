package ru.mirea.database.service.data.property;

import ru.mirea.database.data.entity.property.TypeOfFood;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface TypeOfFoodService {
    TypeOfFood save(TypeOfFood typeOfFood);

    List<TypeOfFood> allTypes();

    Optional<TypeOfFood> getTypeById(Long id) throws NoSuchElementException;

    void deleteTypeById(Long id);
}
