package ru.mirea.database.data.dto.user;

import lombok.Data;

@Data
public class LoginDTO {
    protected String username;
    protected String password;
}
