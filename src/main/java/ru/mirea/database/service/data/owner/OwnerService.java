package ru.mirea.database.service.data.owner;

import ru.mirea.database.data.entity.property.Owner;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface OwnerService {
    Owner save(Owner owner);

    List<Owner> allOwners();

    Optional<Owner> getOwnerById(Long id) throws NoSuchElementException;

    void deleteOwnerById(Long id);
}
