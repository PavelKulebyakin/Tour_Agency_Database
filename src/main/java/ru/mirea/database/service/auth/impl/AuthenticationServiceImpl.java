package ru.mirea.database.service.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.user.SinginDTO;
import ru.mirea.database.data.dto.user.RegisterDTO;
import ru.mirea.database.data.entity.user.Role;
import ru.mirea.database.data.entity.user.UserEntity;
import ru.mirea.database.service.auth.AuthenticationService;
import ru.mirea.database.service.user.RoleService;
import ru.mirea.database.service.user.UserService;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    protected final AuthenticationManager authenticationManager;
    protected final UserService userService;
    protected final RoleService roleService;
    protected final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserService userService,
                                     RoleService roleService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void loginUser(SinginDTO singinDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(singinDTO.getUsername(), singinDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean existByUsername(String username) {
        return userService.existByUsername(username);
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

}
