package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.property.OwnerType;

public interface JpaOwnerTypeRepository
        extends JpaRepository<OwnerType, Long> {
}
