package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.dto.NameIdDTO;
import ru.mirea.database.data.entity.property.TypeOfFood;

import java.util.List;

public interface JpaTypeOfFoodRepository
        extends JpaRepository<TypeOfFood, Long> {

    List<NameIdDTO> findAllBy();

}
