package ru.mirea.database.service.auth;

import ru.mirea.database.data.dto.user.LoginDTO;
import ru.mirea.database.data.dto.user.RegisterDTO;

public interface AuthenticationService {

    void registerUser(RegisterDTO registerDTO);

    void loginUser(LoginDTO loginDTO);

    boolean existByUsername(String username);
}
