package ru.mirea.database.service.data.owner.impl;

import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.NameIdDTO;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.repository.housing.jpa.JpaOwnerRepository;
import ru.mirea.database.service.data.owner.OwnerService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.SortedMap;

@Service
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
    public Owner getOwnerById(Long id) throws NoSuchElementException {
        return ownerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public SortedMap<String, Long> getNamesMap() {
        return NameIdDTO.toSortedMap(ownerRepository.findAllBy());
    }
}
