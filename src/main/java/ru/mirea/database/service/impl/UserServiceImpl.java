package ru.mirea.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.entity.user.UserEntity;
import ru.mirea.database.data.repository.user.UserRepository;
import ru.mirea.database.service.UserService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserEntity getUserByUsername(String username) throws NoSuchElementException {
        Optional<UserEntity> optional = userRepository.findByUsername(username);
        return optional.orElseThrow(() -> new NoSuchElementException("User not found with username: " + username));
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }
}
