package com.example.cars.service;

import com.example.cars.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(Long id);
    void addUser(User user);
    void saveUser(Long id, String firstName, String lastName, String email);
    void deleteUser(Long id);
}
