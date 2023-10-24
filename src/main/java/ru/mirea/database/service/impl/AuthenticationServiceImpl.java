package ru.mirea.database.service.impl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.LoginDTO;
import ru.mirea.database.data.dto.RegisterDTO;
import ru.mirea.database.data.entity.user.Role;
import ru.mirea.database.data.entity.user.UserEntity;
import ru.mirea.database.service.AuthenticationService;
import ru.mirea.database.service.RoleService;
import ru.mirea.database.service.UserService;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserService userService,
                                     RoleService roleService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegisterDTO registerDTO) {
        UserEntity user = UserEntity.builder()
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .build();
        Role userRole = roleService.getRole("USER");
        user.setRole(Set.of(userRole));

        userService.saveUser(user);
    }

    @Override
    public void loginUser(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
