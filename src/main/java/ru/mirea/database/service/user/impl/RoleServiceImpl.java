package ru.mirea.database.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.entity.user.Role;
import ru.mirea.database.data.repository.user.JpaRoleRepository;
import ru.mirea.database.service.user.RoleService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    protected final JpaRoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(JpaRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(String name) {
        Optional<Role> optional = roleRepository.findByName(name);
        return optional.orElseThrow(() -> new NoSuchElementException("Role not found with name: " + name));
    }
}
