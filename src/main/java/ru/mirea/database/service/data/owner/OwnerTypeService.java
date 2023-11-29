package ru.mirea.database.service.data.owner;

import ru.mirea.database.data.entity.property.OwnerType;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface OwnerTypeService {
    OwnerType save(OwnerType ownerType);

    List<OwnerType> allTypes();

    Optional<OwnerType> getTypeById(Long id) throws NoSuchElementException;

    void deleteTypeById(Long id);
}
