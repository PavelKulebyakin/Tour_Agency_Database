package ru.mirea.database.data.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.housing.TypeOfFood;

public interface TypeOfFoodRepository
        extends JpaRepository<TypeOfFood, Long> {
}
