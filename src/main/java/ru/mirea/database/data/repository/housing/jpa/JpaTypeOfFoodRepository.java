package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.property.TypeOfFood;

public interface JpaTypeOfFoodRepository
        extends JpaRepository<TypeOfFood, Long> {
}
