package ru.mirea.database.data.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.user.UserEntity;

import java.util.Optional;
import java.util.Set;

public interface UserRepository
        extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    Set<UserEntity> findAllByRoleName(String roleName);
}
