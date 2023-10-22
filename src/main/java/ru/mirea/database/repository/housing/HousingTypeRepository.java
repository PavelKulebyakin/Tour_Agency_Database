package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.HousingType;

public interface HousingTypeRepository
        extends JpaRepository<HousingType, Long> {
}
