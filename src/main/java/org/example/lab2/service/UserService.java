package org.example.lab2.service;

import org.example.lab2.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public User createUser(User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    public void deleteUser(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }
}

