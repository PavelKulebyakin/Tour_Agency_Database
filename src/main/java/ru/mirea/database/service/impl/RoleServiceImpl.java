package ru.mirea.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.entity.user.Role;
import ru.mirea.database.data.repository.user.RoleRepository;
import ru.mirea.database.service.RoleService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(String name) {
        Optional<Role> optional = roleRepository.findByName(name);
        return optional.orElseThrow(() -> new NoSuchElementException("Role not found with name: " + name));
    }
}
