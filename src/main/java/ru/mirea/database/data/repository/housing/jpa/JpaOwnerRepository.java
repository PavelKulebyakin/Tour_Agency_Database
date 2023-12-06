package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.property.Owner;

import java.util.List;

public interface JpaOwnerRepository
        extends JpaRepository<Owner, Long> {
}
