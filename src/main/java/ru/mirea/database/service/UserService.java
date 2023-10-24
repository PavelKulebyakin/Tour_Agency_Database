package ru.mirea.database.service;

import ru.mirea.database.data.entity.user.UserEntity;

public interface UserService {

    public UserEntity getUserByUsername (String username);

    public Boolean existByUsername (String username);

    void saveUser(UserEntity user);
}
