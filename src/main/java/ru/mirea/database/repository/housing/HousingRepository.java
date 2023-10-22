package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.Housing;

public interface HousingRepository
        extends JpaRepository<Housing, Long> {
}
