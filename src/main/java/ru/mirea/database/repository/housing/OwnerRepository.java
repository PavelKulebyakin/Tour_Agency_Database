package ru.mirea.database.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.entity.housing.Owner;

public interface OwnerRepository
        extends JpaRepository<Owner, Long> {
}
