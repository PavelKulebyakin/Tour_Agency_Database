package ru.mirea.database.service.user;

import ru.mirea.database.data.entity.user.Role;

public interface RoleService {
    Role getRole(String name);
}
