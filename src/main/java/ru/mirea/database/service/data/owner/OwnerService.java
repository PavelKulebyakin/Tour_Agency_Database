package ru.mirea.database.service.data.owner;

import ru.mirea.database.data.entity.property.Owner;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;

public interface OwnerService {
    Owner save(Owner owner);

    List<Owner> allOwners();

    Owner getOwnerById(Long id) throws NoSuchElementException;

    void deleteOwnerById(Long id);

    SortedMap<String, Long> getNamesMap();

}
