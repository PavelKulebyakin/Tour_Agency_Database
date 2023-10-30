package ru.mirea.database.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.mirea.database.data.entity.user.Role;
import ru.mirea.database.data.entity.user.UserEntity;
import ru.mirea.database.data.repository.user.RoleRepository;
import ru.mirea.database.data.repository.user.UserRepository;

@Profile("test")
@Component
public class UserDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDataLoader(RoleRepository roleRepository,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Role roleUser = roleRepository.findByName("USER").orElseThrow();
        Role roleAdmin = roleRepository.findByName("ADMIN").orElseThrow();

        if (userRepository.findByUsername("user").isEmpty()) {
            UserEntity userEntity = UserEntity.builder()
                    .username("userEntity")
                    .password(passwordEncoder.encode("password"))
                    .firstname("")
                    .lastname("")
                    .build();
            userEntity.addRole(roleUser);
            userRepository.save(userEntity);
            userRepository.flush();
        }

        if (userRepository.findByUsername("admin").isEmpty()) {
            UserEntity admin = UserEntity.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("password"))
                    .firstname("")
                    .lastname("")
                    .build();
            admin.addRole(roleUser);
            admin.addRole(roleAdmin);
            userRepository.save(admin);
        }

    }
}
