package ru.mirea.database.service.data.owner.impl;

import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.repository.housing.jpa.JpaOwnerRepository;
import ru.mirea.database.service.data.owner.OwnerService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OwnerServiceImplementation implements OwnerService {
    protected JpaOwnerRepository ownerRepository;

    public OwnerServiceImplementation(JpaOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        ownerRepository.save(owner);
        return owner;
    }

    @Override
    public List<Owner> allOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> getOwnerById(Long id) throws NoSuchElementException {
        Optional<Owner> owner = ownerRepository.findById(id);
        if(owner.isPresent()) {
            return owner;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }
}
