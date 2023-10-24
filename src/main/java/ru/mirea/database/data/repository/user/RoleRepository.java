package ru.mirea.database.data.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.user.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository
        extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    Boolean existsByName(String name);
}
