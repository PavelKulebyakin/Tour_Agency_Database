package ru.mirea.database.service.auth;

import ru.mirea.database.data.dto.user.SinginDTO;
import ru.mirea.database.data.dto.user.RegisterDTO;

public interface AuthenticationService {

    void registerUser(RegisterDTO registerDTO);

    void loginUser(SinginDTO singinDTO);

    boolean existByUsername(String username);
}
