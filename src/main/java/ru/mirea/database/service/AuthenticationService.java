package ru.mirea.database.service;

import ru.mirea.database.data.dto.LoginDTO;
import ru.mirea.database.data.dto.RegisterDTO;

public interface AuthenticationService {

    void registerUser(RegisterDTO registerDTO);

    void loginUser(LoginDTO loginDTO);

    boolean existByUsername(String username);
}
