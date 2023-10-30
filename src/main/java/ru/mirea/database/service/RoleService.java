package ru.mirea.database.service;

import ru.mirea.database.data.entity.user.Role;

public interface RoleService {
    Role getRole(String name);
}
