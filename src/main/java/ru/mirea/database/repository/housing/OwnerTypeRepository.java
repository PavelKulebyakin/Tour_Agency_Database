package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.OwnerType;

public interface OwnerTypeRepository
        extends JpaRepository<OwnerType, Long> {
}
