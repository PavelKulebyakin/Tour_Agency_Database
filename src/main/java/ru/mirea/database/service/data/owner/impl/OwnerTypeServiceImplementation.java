package ru.mirea.database.service.data.owner.impl;

import ru.mirea.database.data.entity.property.OwnerType;
import ru.mirea.database.data.repository.housing.jpa.JpaOwnerTypeRepository;
import ru.mirea.database.service.data.owner.OwnerTypeService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OwnerTypeServiceImplementation implements OwnerTypeService {
    protected JpaOwnerTypeRepository ownerTypeRepository;

    public OwnerTypeServiceImplementation(JpaOwnerTypeRepository ownerTypeRepository) {
        this.ownerTypeRepository = ownerTypeRepository;
    }

    @Override
    public OwnerType save(OwnerType ownerType) {
        return ownerTypeRepository.save(ownerType);
    }

    @Override
    public List<OwnerType> allTypes() {
        return ownerTypeRepository.findAll();
    }

    @Override
    public Optional<OwnerType> getTypeById(Long id) throws NoSuchElementException {
        Optional<OwnerType> ownerType = ownerTypeRepository.findById(id);
        if(ownerType.isPresent()) {
            return ownerType;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteTypeById(Long id) {
        ownerTypeRepository.deleteById(id);
    }
}
