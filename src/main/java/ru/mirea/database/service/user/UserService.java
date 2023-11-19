package ru.mirea.database.service.user;

import ru.mirea.database.data.entity.user.UserEntity;

public interface UserService {

    UserEntity getUserByUsername(String username);

    Boolean existByUsername(String username);

    void saveUser(UserEntity user);
}
