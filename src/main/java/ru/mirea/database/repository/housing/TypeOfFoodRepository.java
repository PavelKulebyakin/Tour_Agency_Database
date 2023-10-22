package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.TypeOfFood;

public interface TypeOfFoodRepository
        extends JpaRepository<TypeOfFood, Long> {
}
